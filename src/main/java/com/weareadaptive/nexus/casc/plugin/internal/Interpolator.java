package com.weareadaptive.nexus.casc.plugin.internal;

import org.sonatype.goodies.common.ComponentSupport;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
public class Interpolator extends ComponentSupport {
    public String interpolate(String str) {
        String pattern = "\\$(([A-Z0-9_]+)|\\{([^:}]+)(:(\"([^\"}]*)\"|([^}]*)))?})";
        Pattern expr = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = expr.matcher(str);
        while (matcher.find()) {
            String varName = matcher.group(2);
            if (varName == null) {
                varName = matcher.group(3);
            }
            String defaultValue = matcher.group(6);
            if (defaultValue == null) {
                defaultValue = matcher.group(7);
            }

            String value = null;

            if ("file".equalsIgnoreCase(varName)) {
                if (defaultValue == null || defaultValue.trim().isEmpty()) {
                    log.error("Missing filename in {}", str);
                    continue;
                }

                File f = new File(defaultValue);

                if (!f.exists()) {
                    log.error("File {} does not exist", f.getAbsolutePath());
                    continue;
                }

                try {
                    value = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    log.error("Failed to read file {}", defaultValue);
                }
            } else {
                value = System.getenv(varName.toUpperCase());
            }

            log.warn("interpolated string '{}' as {} : {}", str, varName, value);

            if (value == null) {
                if (defaultValue == null) {
                    log.warn("xxx Found no value to interpolate variable {}", varName);
                    continue;
                }

                value = defaultValue;
            }

            log.warn("interpolated string '{}' as {} : {}", str, varName, value);

            Pattern subexpr = Pattern.compile(Pattern.quote(matcher.group(0)));
            str = subexpr.matcher(str).replaceAll(value);
        }

        return str;
    }
}
