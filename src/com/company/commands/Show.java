package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Show extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {

       //  h.getHumanBeings().stream().forEach();
        System.out.println( h.getHumanBeings().stream().map(s->s.
                toString().concat("\n")).collect(Collectors.toList()));

                /*collect(Collectors.collectingAndThen(List<HumanBeing>, )));
        Stream.Builder<HumanBeing> streamBuider = Stream.<HumanBeing>builder()
                .add(h.getHumanBeings().get())*/
              //stream().collect(Collectors.toList());

       // h.getHumanBeings().stream().toArray(Object[]::new);


/*
        if (h.getHumanBeings().size() != 0) {

            return "d";
        } else return "Коллекция пуста.";*/
        //System.out.println(h.getHumanBeings());

            List<HumanBeing> collection = h.getHumanBeings();
            StringBuilder result = new StringBuilder();
            if (h.getHumanBeings().size() != 0) {
                for (int i = 0; i < h.getHumanBeings().size(); i++) {
                    result.append(h.getHumanBeings().get(i)).append("\n");
                 //   System.out.println(h.getHumanBeings().get(i));
                }
                return h.getHumanBeings().stream().map(s->s.toString().concat("/n")).toString();
            } else return "Коллекция пуста.";
        }

    }
