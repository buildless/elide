
dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("../gradle/elide.versions.toml"))
    }
  }
}
