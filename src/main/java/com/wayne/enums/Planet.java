package com.wayne.enums;

/**
 * 太阳系的行星
 * Enum type with data and behavior
 * @author wayne
 */
public enum Planet {
    /**
     * 水星
     */
    MERCURY(3.302e+23 , 2.439e6 ),
    /**
     * 金星
     */
    VENUS(4.869e+24 , 6.052e6 ),
    /**
     * 地球
     */
    EARTH(5.975e+24 , 6.378e6 ),
    /**
     * 火星
     */
    MARS(6.419e+23 ,3.393e6 ),
    /**
     * 木星
     */
    JUPITER(1.899e+27 ,7.149e7 ),
    /**
     * 土星
     */
    SATURN(5.685e+26 ,6.027e7 ),
    /**
     * 天王星
     */
    URANUS(8.683e+25 ,2.566e7 ),
    /**
     * 海王星
     */
    NEPTUNE(1.024e+26 ,2.477e7 );

    /**
     * 质量，单位：千克
     */
    private final double mass;
    /**
     * 半径，单位米
     */
    private final double radius;
    /**
     * 表面重力
     */
    private final double surfaceGravity;
    /**
     * 万有引力常数
     */
    private static final double G = 6.67300E-11 ;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass(){
        return mass;
    }

    public double radius(){
        return radius;
    }

    public double surfaceGravity(){
        return surfaceGravity;
    }

    public double surfaceGravity(double mass){
        return mass * surfaceGravity;
    }
}
