# spock-tests

## Configurações para Eclipse:
* Instalar Groovy-Eclipse plugin
    * Neon: Install new softwate [http://dist.springsource.org/snapshot/GRECLIPSE/e4.6/]

## Configurações para IntelliJ IDEA:
* ?

## TODO
* Add tests with Mock
* Add tests with Stub of dao service
* Add tests with @Issue("JIRA-561") annotation
* Add tests with conditional -> @Requires({ !new CreditCardProcessor().online() })
* Add tests with ignore -> @IgnoreRest and @IgnoreIf({ !new CreditCardProcessor().online() })
* Add tests with tables -> see com.manning.spock.chapter3.nuclear.NuclearReactorSpec
