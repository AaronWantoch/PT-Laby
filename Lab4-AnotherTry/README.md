# Technological Platforms

Project contains examples for Technological  Platforms classes conducted at the Gdańsk University of Technology.

[![MIT licensed][shield-mit]](LICENSE)
[![Java v11][shield-java]](https://openjdk.java.net/projects/jdk/11/)

## Requirements

The list of tools required to build and run the project:

* Open JDK 11.x+
* Apache Maven 3.5.x+

## Building

In order to build project generating jar archive use:

```bash
mvn clean package
```

In order to build project generating jar, sources and javadoc archives use:

```bash
mvn -Prelease clean package
```

If your default `java` is not from JDK 11 or higher use:

```bash
JAVA_HOME=<path_to_jdk_home> mvn package
```

## Running

In order to run use:

```bash
java -jar target/simple-rpg-1.0.0-SNAPSHOT.jar
```

If your default `java` is not from JDK 11 or higher use:

```bash
<path_to_jdk_home>/bin/java -jar target/simple-rpg-1.0.0-SNAPSHOT.jar
```

## License

Project is licensed under the [MIT](LICENSE) license.  

## Credits

All character's portraits were created using [DMHeroes](http://dmheroes.com/) developed by
[Christian Oesch](https://twitter.com/ChristianOesch).

## Author

Copyright &copy; 2020, Michał (psysiu) Wójcik

[![][gravatar-psysiu]]()

[shield-mit]: https://img.shields.io/badge/license-MIT-blue.svg
[shield-java]: https://img.shields.io/badge/Java-11-blue.svg
[shield-jakarta]: https://img.shields.io/badge/Jakarta_EE-8-blue.svg
[gravatar-psysiu]: https://s.gravatar.com/avatar/b61b36a5b97ca33e9d11d122c143b9f0
