package com.example.viikko11;

import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageChanger {

        public static void changeLocale(Resources res, String locale) {

            Configuration config;
            config = new Configuration(res.getConfiguration());


            switch (locale) {
                case "Suomi":
                    config.locale = new Locale("fi");
                    break;
                case "English":
                    config.locale = new Locale("En");
                    break;

                default:
                    config.locale = Locale.ENGLISH;
                    break;
            }
            res.updateConfiguration(config, res.getDisplayMetrics());

        }
}

