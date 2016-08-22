# spock-tests

## Configurações para Eclipse:
* Instalar Groovy-Eclipse plugin
    * Eclipse Mars: Install new softwate [http://dist.springsource.org/snapshot/GRECLIPSE/e4.5/]
    * Eclipse Neon: Install new softwate [http://dist.springsource.org/snapshot/GRECLIPSE/e4.6/]

## Configurações para IntelliJ IDEA:
* ?

## TODO
* Add tests with Mock
* Add tests with Stub of dao service
* Add tests with conditional -> @Requires({ !new CreditCardProcessor().online() })
* Add tests with ignore -> @IgnoreRest and @IgnoreIf({ !new CreditCardProcessor().online() })
