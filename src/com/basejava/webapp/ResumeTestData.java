package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("firstName1");

        TextSection resumeTextObjective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        TextSection resumeTextPersonal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        TextSection resumeAchievements = new TextSection("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.\n" +
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.\n" +
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).\n" +
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        TextSection resumeQualification = new TextSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n" +
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n" +
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,\n" +
                "MySQL, SQLite, MS SQL, HSQLDB\n" +
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,\n" +
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,\n" +
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).\n" +
                "Python: Django.\n" +
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js\n" +
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka\n" +
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.\n" +
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,\n" +
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.\n" +
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования\n" +
                "Родной русский, английский \"upper intermediate\"");

        ExperienceWork resumeExperienceWorkJavaOnlineProjects = new ExperienceWork("http://javaops.ru/", LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        ExperienceWork resumeExperienceWorkWrike = new ExperienceWork("https://www.wrike.com/", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, " +
                        "Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация " +
                        "по OAuth1, OAuth2, JWT SSO.");
        ExperienceWork resumeExperienceWorkRitCenter = new ExperienceWork("no url", LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1), "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                        "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование " +
                        "системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка " +
                        "интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, " +
                        "экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                        "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote " +
                        "scripting via ssh tunnels, PL/Python");
        ExperienceWork resumeExperienceWorkLuxoftDeutscheBank = new ExperienceWork("http://www.luxoft.ru/", LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, " +
                        "Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для " +
                        "администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, " +
                        "Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        ExperienceWork resumeExperienceWorkYota = new ExperienceWork("https://www.yota.ru/", LocalDate.of(2008, 6, 1), LocalDate.of(2010, 12, 1), "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                        "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX " +
                        "клиента (Python/ Jython, Django, ExtJS)");
        ExperienceWork resumeExperienceWorkEnkata = new ExperienceWork("http://enkata.com/", LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                        "частей кластерного J2EE приложения (OLAP, Data mining).");
        ExperienceWork resumeExperienceWorkSiemensAG = new ExperienceWork("https://www.siemens.com/ru/ru/home.html", LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1), "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на " +
                        "мобильной IN платформе Siemens @vantage (Java, Unix).");
        ExperienceWork resumeExperienceWorkAlcatel = new ExperienceWork("http://www.alcatel.ru/", LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1), "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        ExperienceWork resumeExperienceWorkLearnCoursera = new ExperienceWork("https://www.coursera.org/course/progfun", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "Functional Programming Principles in Scala\" by Martin Odersky", "-");
        ExperienceWork resumeExperienceWorkLearnLuxoft = new ExperienceWork("http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "-");
        ExperienceWork resumeExperienceWorkLearnSiemensAG = new ExperienceWork("http://www.siemens.ru/", LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1), "3 месяца обучения мобильным IN сетям (Берлин)", "-");
        ExperienceWork resumeExperienceWorkLearnItmoAspirant = new ExperienceWork("http://www.ifmo.ru/", LocalDate.of(1993, 3, 1), LocalDate.of(1996, 7, 1), "Аспирантура (программист С, С++)", "-");
        ExperienceWork resumeExperienceWorkLearnItmoOchno = new ExperienceWork("http://www.ifmo.ru/", LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1), "Инженер (программист Fortran, C)", "-");
        ExperienceWork resumeExperienceWorkLearnItmoZaochno = new ExperienceWork("http://www.school.mipt.ru/", LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 6), "Закончил с отличием", "-");

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.MAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB, "https://github.com/gkislin");
        contacts.put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.HOME_PAGE, "https://stackoverflow.com/users/548473");

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.OBJECTIVE, resumeTextObjective);
        sections.put(SectionType.PERSONAL, resumeTextPersonal);
        sections.put(SectionType.ACHIEVEMENT, resumeAchievements);
        sections.put(SectionType.QUALIFICATIONS, resumeQualification);

        ArrayList<ExperienceWork> listWork = new ArrayList<>();
        listWork.add(resumeExperienceWorkJavaOnlineProjects);
        listWork.add(resumeExperienceWorkWrike);
        listWork.add(resumeExperienceWorkRitCenter);
        listWork.add(resumeExperienceWorkLuxoftDeutscheBank);
        listWork.add(resumeExperienceWorkYota);
        listWork.add(resumeExperienceWorkEnkata);
        listWork.add(resumeExperienceWorkSiemensAG);
        listWork.add(resumeExperienceWorkAlcatel);

        ExperienceSection experienceSectionWork = new ExperienceSection(listWork);
        sections.put(SectionType.EXPERIENCE, experienceSectionWork);

        ArrayList<ExperienceWork> listEducation = new ArrayList<>();
        listEducation.add(resumeExperienceWorkLearnCoursera);
        listEducation.add(resumeExperienceWorkLearnLuxoft);
        listEducation.add(resumeExperienceWorkLearnSiemensAG);
        listEducation.add(resumeExperienceWorkLearnItmoAspirant);
        listEducation.add(resumeExperienceWorkLearnItmoOchno);
        listEducation.add(resumeExperienceWorkLearnItmoZaochno);

        ExperienceSection experienceSectionLearn = new ExperienceSection(listEducation);
        sections.put(SectionType.EXPERIENCE, experienceSectionLearn);

        ArrayList<Object> listResume = new ArrayList<>();
        listResume.add(contacts);
        listResume.add(sections);

        Map<Resume, ArrayList<Object>> resumeOne = new HashMap<>();
        resumeOne.put(resume, listResume);

        for (Map.Entry<Resume, ArrayList<Object>> entry : resumeOne.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}