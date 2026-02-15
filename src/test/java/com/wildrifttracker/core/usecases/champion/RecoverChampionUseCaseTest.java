package com.wildrifttracker.core.usecases.champion;

import com.wildrifttracker.infra.database.models.Champion;
import com.wildrifttracker.infra.database.repositories.ChampionRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Core :: Usecases :: Champion :: RecoverItemUseCaseTest")
public class RecoverChampionUseCaseTest {
    @DisplayName("Testing method: getAll")
    @Test
    public void getAllTest() {
        ChampionRepository championRepository = Mockito.mock(ChampionRepository.class);

        RecoverChampionUseCase useCaseTest = new RecoverChampionUseCase(championRepository);

        List<Champion> championResult = new ArrayList<>();

        championResult.add(new Champion());
        championResult.add(new Champion());

        Mockito.when(championRepository.findAll()).thenReturn(championResult);

        List<Champion> useCaseResult = useCaseTest.getAll();

        assertEquals(2, useCaseResult.size());
        assertEquals(championResult.size(), useCaseResult.size());
    }

    @DisplayName("Testing method: getById")
    @Test
    public void getByIdTest() {
        ChampionRepository championRepository = Mockito.mock(ChampionRepository.class);

        RecoverChampionUseCase useCaseTest = new RecoverChampionUseCase(championRepository);

        Champion championResult = new Champion();

        championResult.setName("test");

        Mockito.when(championRepository.findById(123L)).thenReturn(Optional.of(championResult));

        Champion useCaseResult = useCaseTest.getById(123L);

        assertEquals(championResult.getName(), useCaseResult.getName());
    }

    @DisplayName("Testing method: getById - Not Found")
    @Test
    public void getByIdNotFoundExceptionTest() {
        ChampionRepository championRepository = Mockito.mock(ChampionRepository.class);

        RecoverChampionUseCase useCaseTest = new RecoverChampionUseCase(championRepository);

        Mockito.when(championRepository.findById(123L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCaseTest.getById(123L));
    }
}
