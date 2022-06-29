ARG SONATYPE_IMAGE=sonatype/nexus3:latest

# hadolint ignore=DL3006
FROM openjdk:8-jdk-alpine as BUILDER

COPY . "/build"
WORKDIR "/build"
RUN ./mvnw package -Dkar.finalName=nexus-casc-plugin

# hadolint ignore=DL3006
FROM ${SONATYPE_IMAGE}
COPY --from=BUILDER /build/target/nexus-casc-plugin-bundle.kar /opt/sonatype/nexus/deploy/nexus-casc-plugin.kar
