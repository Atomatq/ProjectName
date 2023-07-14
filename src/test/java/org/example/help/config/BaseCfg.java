package org.example.help.config;

public interface BaseCfg extends org.aeonbits.owner.Config {
    @DefaultValue("http://pp86.hostco.ru/")
    String baseURL();
    @Key("user.name")
    String userName();

    @Key("user.password")
    String password();

}
