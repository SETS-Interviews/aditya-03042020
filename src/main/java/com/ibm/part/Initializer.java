package com.ibm.part;

import com.ibm.part.domain.PartNumber;
import com.ibm.part.repository.PartNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
class Initializer implements CommandLineRunner {

    @Autowired
    private PartNumberRepository repository;

    private static final String COMMA_DELIMITER = ",";
    private static final String SAAS = "SaaS";
    private static final String SW = "SW";


    /**
     * This is were the CSV files provide in the cmd lines
     * are read and loaded
     * into the NoSQL DB
     */
    @Override
    public void run(String... args) {
        try {
            for(String arg: args) {
                final String dealType = arg.split("=")[0];
                final String fileName = arg.split("=")[1];
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line = br.readLine(); // first line is headers anyway -- so discard this
                while ((line = br.readLine()) != null) { //Loading one line at a time allows us to load unlimited amount of data without causing memory issues
                    String[] values = line.split(COMMA_DELIMITER);
                    if(dealType.equals(SAAS)) {
                        repository.save(new PartNumber(values[0], //PART_NUM
                                                        values[1],//DEAL_REG_GROUP
                                                        values[2],//START_DATE
                                                        values[3],//END_DATE
                                                        values[4],//ADD_DATE
                                                        values[5],//MODIFIED_DATE
                                                        SAAS));
                    } else {
                        repository.save(new PartNumber(values[0], //PART_NUM
                                                        values[1],//DEAL_REG_GROUP
                                                        values[2],//START_DATE
                                                        values[3],//END_DATE
                                                        values[4],//ACTIVE_FLAG
                                                        values[5],//ADD_DATE
                                                        values[6],//MODIFIED_DATE
                                                        SW));
                    }
                }
            }
        } catch(FileNotFoundException ex) {
            System.out.print(ex);
        } catch (IOException ex) {
            System.out.print(ex);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
}