package org.example.help.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface BaseCfg extends Config {
    @DefaultValue("chrome")
    String browser();

    @DefaultValue("http://pp86.hostco.ru/")
    String baseURL();
    @Key("user.name")
    String userName();

    @Key("user.password")
    String password();

    @DefaultValue("latest")
    @Key("browser.${browser}.version")
    String browserVersion();
}
