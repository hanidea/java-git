package reflect;

import reflect.hero.Camille;
import reflect.hero.Diana;
import reflect.hero.Irelia;

public class HeroFactory {
    public static ISkill getHero(String name) throws Exception {
        ISkill iSkill;
        //元类
        //类是对对象的抽象，元类是对类的描述
        String classStr = "reflect.hero."+name;
        Class<?> cla = Class.forName(classStr);
        Object obj = cla.newInstance();
        //jdk 9+ newInstance废弃
        //clazz.getDeclaredConstructor().newInstance()
        return (ISkill)obj;
        //return iSkill;

    }
}
