package by.paramonov;

import by.paramonov.processor.Processor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckRunner implements ApplicationRunner {
    Processor processor;

    public CheckRunner(Processor processor){
        this.processor = processor;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        processor.process(args.getSourceArgs());
    }
}
