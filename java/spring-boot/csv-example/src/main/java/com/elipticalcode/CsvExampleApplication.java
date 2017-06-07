package com.elipticalcode;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;

@SpringBootApplication
public class CsvExampleApplication implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {

		String outputFile = "C:\\Users\\crono\\out.csv";

		CSVFormat format = CSVFormat.EXCEL.withHeader("test1", "test2");

		try(FileWriter writer = new FileWriter(outputFile);
			CSVPrinter printer = new CSVPrinter(writer, format);) {

			printer.printRecord(1,"tes,tthis\nis,something");
			printer.printRecord(1,"test");
			printer.printRecord(1,"test");
			printer.printRecord(1,"test");
			printer.printRecord(1,"test");

		}

	}

	public static void main(String[] args) {
		SpringApplication.run(CsvExampleApplication.class, args);
	}
}
