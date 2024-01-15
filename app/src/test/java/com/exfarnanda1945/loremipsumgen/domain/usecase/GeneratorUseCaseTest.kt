package com.exfarnanda1945.loremipsumgen.domain.usecase

import com.exfarnanda1945.loremipsumgen.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.utils.Resource
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GeneratorUseCaseTest {
    @Mock
    private lateinit var repository: IGeneratorRepository

    private lateinit var useCase: GeneratorUseCase

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GeneratorUseCase(repository)
    }

    @Test
    fun `Should return Resource Success`() {
        Mockito.`when`(repository.generate("test123")).thenReturn(Resource.success("test123"))

        val result = useCase("test123")
        assertEquals(Resource.success("test123"), result)
    }

    @Test
    fun `Should return Resource Failure`() {
        Mockito.`when`(repository.generate("test123")).thenReturn(Resource.failure("Internal Server Error"))

        val result = useCase("test123")
        assertEquals(Resource.failure<String>(message = "Internal Server Error"), result)
    }
}