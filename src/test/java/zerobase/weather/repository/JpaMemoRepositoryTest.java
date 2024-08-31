package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {

        Memo NewMemo = new Memo(10, "this is jpa mempo");

        jpaMemoRepository.save(NewMemo);

        List<Memo> all = jpaMemoRepository.findAll();

        assertTrue(all.size() > 0);
    }


    @Test
    void findByIdTest() {
        Memo NewMemo = new Memo(10, "this is jpa");

        Memo save = jpaMemoRepository.save(NewMemo);
        Optional<Memo> byId = jpaMemoRepository.findById(save.getId());
        assertEquals(byId.get().getText(), "this is jpa");
    }
}