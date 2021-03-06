package com.pelzer.util

@Log
class GroovyLoggingTest {
  void groovyASTErrorTest() {
    def regularString = "I'm a regular groovy string"
    def stringWithEnum = "I'm a regular groovy-style string, with an enum in me. $Foo.FOO"

    // These lines go through without issue
    log.debug("I'm a log statement that causes no problem.")
    log.debug(stringWithEnum)
    log.info("I'm a log statement that causes no problem.")
    log.info(stringWithEnum)

    // The following lines cause the compiler to poop the bed.
    log.debug("I have another string in me: $regularString")
    log.debug("Groovy $stringWithEnum")
    log.debug("I cause the Groovy compiler to poop the bed $Foo.FOO")
    log.debug("I also cause the Groovy compiler to poop the bed {}", Foo.FOO)

    log.info("I have another string in me: $regularString")
    log.info("Groovy $stringWithEnum")
    log.info("I cause the Groovy compiler to poop the bed $Foo.FOO")
    log.info("I also cause the Groovy compiler to poop the bed {}", Foo.FOO)
  }

  enum Foo {
    FOO, BAR, JAR
  }
}

