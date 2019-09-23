package psoft.ufcg.lab2.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.ufcg.lab2.Entities.Disciplina;
import psoft.ufcg.lab2.Repository.DisciplinasRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinasRepository disciplinaRepository;

    public DisciplinaService(){}

    @PostConstruct
    public void initDisciplina (){
        if (disciplinaRepository.count() > 0 )
            return;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/disciplinas.json");
        try {
            List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
            this.disciplinaRepository.saveAll(disciplinas);
        } catch (IOException e) {
            System.out.println("Disciplina nao salva");
        }
    }


}
