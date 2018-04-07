package com.oksana.zakharchenko.customenum;

public class CustomEnum extends AbstractCustomEnum<CustomEnum>{

    public static final CustomEnum LOW = new CustomEnum("LOW");
    public static final CustomEnum MEDIUM = new CustomEnum("MEDIUM");
    public static final CustomEnum HIGH = new CustomEnum("HIGH");


    private CustomEnum(String name) {
        super(name);
    }

 }
