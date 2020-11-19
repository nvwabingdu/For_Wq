package com.example.annotations;



import com.example.annotations.annotation.cls.BindView;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class ClassProcessor extends AbstractProcessor {

    /**
     * @param processingEnv
     * 被注解处理工具调用，，并传入ProcessingEnvironment参数，ProcessingEnvironment提供了很多
     * 有用的工具类，Elements，Types,Filer,Messager
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }


    /**
     * @param annotations
     * @param roundEnv
     * @return
     * 相当于每一个处理器的主函数main(),在这里写你的扫描，评估和处理注解的代码，以及生产java文件，输入参数RoundEnviroment
     * 可以让你查询出包含特定注解的被注解元素。
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (Element element : roundEnv.getElementsAnnotatedWith(BindView.class)) {
            if (element.getKind() == ElementKind.FIELD) {;
                messager.printMessage(Diagnostic.Kind.NOTE, "printMessage:" + element.toString());
            }
        }
        return true;
    }

    /**
     * @return
     * 这是必须指定的方法，，指定这个注解处理器是注册给那个注解的，注意，它返回一个字符串的集合，
     * 包含本处理器想要处理的注解类型的合法全程。
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        annotataions.add(BindView.class.getCanonicalName());
        return annotataions;
    }


    /**
     * @return
     * 用来指定你是用java版本，这里通常返回SourceVersion.latestSupported()
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
