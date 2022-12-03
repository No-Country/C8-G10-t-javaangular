package NoCountry.YouTech.utils.seeder;

import NoCountry.YouTech.model.Tag;
import NoCountry.YouTech.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class SeederDataBaseImpl implements CommandLineRunner, ISeederDataBase {

    private final TagRepository repository;
    private final MessageSource messageSource;


    private final Logger LOG = LoggerFactory
            .getLogger(SeederDataBaseImpl.class);

    @Override
    public void run(String... args) throws Exception {
        seedTagsTable();
    }

    @Override
    public void seedTagsTable() {
        List<Tag> tags = null;
        if (repository.count() == 0) {
            tags = new ArrayList<>();
            tags.add(new Tag(1, "Java", (short) 1));
            tags.add(new Tag(2, "Angular", (short) 1));
            tags.add(new Tag(3, "React", (short) 1));
            tags.add(new Tag(4, "Javascript", (short) 1));
            tags.add(new Tag(5, "C++", (short) 1));
            tags.add(new Tag(6, "Spring", (short) 1));
            tags.add(new Tag(7, "Nodejs", (short) 1));

            repository.saveAll(tags);

            LOG.info(messageSource.getMessage("info-positive",
                    new Object[]{"Tags table", 7}, Locale.US));
        } else {
            LOG.info(messageSource.getMessage("info-negative",
                    new Object[]{"Tags table"}, Locale.US));
        }
    }

}
