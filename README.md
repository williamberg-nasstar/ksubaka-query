The initial commit used to be divided up better, but thanks to Cygwin I spent a couple of hours mashing up the git history until it was completely irretrievable (e.g. most of the pom.xml was derived from no known commit). In the interests of preserving my sanity I have condensed those commits into a single one. I always develop on a Linux box for work and the incidence of git-related tangles is much lower.

A build of the project is available at:

http://wberg.mine.nu/p/ksubaka/query.jar

Example usage:

<code>​java -jar ­Dapi=imdb ­Dmovie="Indiana Jones" query.jar</code>

​<code>java -jar ­Dapi=omdb ­Dmovie="Star Wars" query.jar</code>
