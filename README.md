# Apache Shiro tags for Freemarker

[Apache Shiro](http://shiro.apache.org/) comes with some [handy JSP tags](http://shiro.apache.org/jsp-tag-library.html) for doing things like only showing content for anonymous users, logged in users, etc... I'm using [Freemarker](http://freemarker.sourceforge.net/) and didn't want to take a dependency on JSP just for Shiro, so I rewrote the tags for Freemarker.

## Install

Either download the [dist/shiro-freemarker-tags-0.1-SNAPSHOT.jar](/jagregory/shiro-freemarker-tags/raw/master/dist/shiro-freemarker-tags-0.1-SNAPSHOT.jar) or take all the java files and stick them in your project. Simple.

If there's enough demand, I could put this up on Maven.

## Usage

Declare a shared variable called "shiro", and assign it to an instance of the ShiroTags class.

    cfg.setSharedVariable("shiro", new ShiroTags());

You should then be able to use the tags in your Freemarker templates.

    <@shiro.guest>Hello guest!</@shiro.guest>

## License

Do what you want with it, just don't blame me if it breaks anything.