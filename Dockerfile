ARG SONATYPE_IMAGE=sonatype/nexus3:3.70.1-java11

# hadolint ignore=DL3006
FROM amazoncorretto:11-alpine3.19-jdk as BUILDER

COPY . "/build"
WORKDIR "/build"
RUN ./mvnw package -Dkar.finalName=nexus-casc-plugin

# hadolint ignore=DL3006
FROM ${SONATYPE_IMAGE}
COPY --from=BUILDER /build/target/nexus-casc-plugin-bundle.kar /opt/sonatype/nexus/deploy/nexus-casc-plugin.kar
