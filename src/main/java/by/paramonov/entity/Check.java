package by.paramonov.entity;

import lombok.Data;


@Data
public class Check {
    static final String CHECK_START = """
            \t\t\tCASH RECEIPT
            =========================================
            QTY\tDESCRIPTION\t\t\tPRICE\t\tTOTAL""";
    private String output;
}
