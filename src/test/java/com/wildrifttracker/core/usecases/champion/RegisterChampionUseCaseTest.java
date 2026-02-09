package com.wildrifttracker.core.usecases.champion;

import com.wildrifttracker.infra.database.models.Champion;
import com.wildrifttracker.domain.dtos.champion.CreateChampionPayloadDto;
import com.wildrifttracker.infra.database.repositories.ChampionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Core :: Usecases :: Champion :: RegisterChampionUseCaseTest")
public class RegisterChampionUseCaseTest {
    @DisplayName("Testing method: create")
    @Test
    public void createTest() {
        String name = "varus";
        String role = "adc";
        String difficultyLevel = "hard";
        String type = "marksman";
        String riotReferenceUrl = "https://riot.com";

        ChampionRepository championRepository = Mockito.mock(ChampionRepository.class);

        CreateChampionPayloadDto payloadTest = new CreateChampionPayloadDto(
                name,
                role,
                difficultyLevel,
                type,
                riotReferenceUrl
        );
        RegisterChampionUseCase useCaseTest = new RegisterChampionUseCase(championRepository);

        Champion championResult = new Champion();
        championResult.setName(name);

        Mockito.when(championRepository.save(Mockito.any(Champion.class))).thenReturn(championResult);

        Champion useCaseResult = useCaseTest.create(payloadTest);

        assertEquals(name, useCaseResult.getName());
    }
}
