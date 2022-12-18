package by.paramonov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class Check extends BaseEntity{
    static final String CHECK_START = """
            \t\t\tCASH RECEIPT
            =========================================
            QTY\tDESCRIPTION\t\t\tPRICE\t\tTOTAL""";
    private String output;
}
