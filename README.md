# JAKtor
free LGPL inspired Erlang Large Aktor conception for sending messaging via http. Used JDK11 HTTP CLIENT and JAVALIN Server for receing. Excellent to exchange huge messages and files.


PACKAGE: mvn package


STARTING :
                    <PATH BUILDS>       <MODULE>   <PACKAGE><class>
java --module-path target/modules -m se.roland.jaktor/impl.JAktor


To reuse module in maven => mvn clean install

add in dependency


        <dependency>
            <groupId>se.roland</groupId>
            <artifactId>JAKtor</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>


        