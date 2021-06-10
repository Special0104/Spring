package ru.specialist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class BuilderConfig {

    @Bean("myPoint")
    @Scope("prototype")
    public Point buildPoint() {
        return new Point(100, 100);
    }

    @Bean("myCircle")
    @Scope("prototype")
    public Circle buildCircle(int r){
        
        return new Circle(buildPoint(), r);
    }

    @Bean("myScene")
    public Scene buildScene() {
        Scene sc = new Scene();
        sc.objects = new ArrayList<Shape>(
                Arrays.asList(
                        buildCircle(100),
                        buildPoint(),
                        buildCircle(200)
                )
        );
        sc.setColor("white");
        return sc;
    }


}
