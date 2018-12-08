package view;


import controller.utility.Mailer;
import freemarker.template.*;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TemplateControllerMail {
    public static void process(String templateName, Map data, String[] to, String subject, ServletContext servlet_context){
        Configuration cfg = SingletonFreemarkerConfig.INSTANCE.getCfg(servlet_context);
        Template template;
        String msg = "";
        try{
            template = cfg.getTemplate(templateName);
            StringWriter stringWriter = new StringWriter();
            template.process(data, stringWriter);
            msg = stringWriter.toString();
        } catch (TemplateException | IOException ex) {

            //log dei dettagli dell'eccezione
            Logger.getAnonymousLogger().log(Level.SEVERE, "Templating exception: " + ex.getMessage());

        }
        for (String s : to) {
            Mailer.send(s, subject, msg);
            System.out.println("INVIATO A " + s);
        }
    }
}
