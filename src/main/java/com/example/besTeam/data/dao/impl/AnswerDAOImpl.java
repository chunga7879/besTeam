package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.AbilityDAO;
import com.example.besTeam.data.dao.AnswerDAO;
import com.example.besTeam.data.dao.RoleDAO;
import com.example.besTeam.data.entity.*;
import com.example.besTeam.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerDAOImpl implements AnswerDAO {
    private AnswerRepository answerRepository;
    private AbilityAnswerRepository abilityAnswerRepository;
    private RoleAnswerRepository roleAnswerRepository;
    private PreferMateAnswerRepository preferMateAnswerRepository;

    private RoleDAO roleDAO;
    private AbilityDAO abilityDAO;

    @Autowired
    public AnswerDAOImpl(AnswerRepository answerRepository
            , AbilityAnswerRepository abilityAnswerRepository
            , RoleAnswerRepository roleAnswerRepository
            , PreferMateAnswerRepository preferMateAnswerRepository
            , RoleDAO roleDAO, AbilityDAO abilityDAO) {
        this.answerRepository = answerRepository;
        this.abilityAnswerRepository = abilityAnswerRepository;
        this.roleAnswerRepository = roleAnswerRepository;
        this.preferMateAnswerRepository = preferMateAnswerRepository;
        this.roleDAO = roleDAO;
        this.abilityDAO = abilityDAO;
    }

    public RoleAnswer saveRoleAnswer(RoleAnswer roleAnswer) throws Exception {
        Role role = roleDAO.getRoleById(roleAnswer.getRole().getId());
        RoleAnswer roleAnswerEntity = RoleAnswer.builder().role(role).preference(roleAnswer.getPreference()).build();
        roleAnswerEntity = roleAnswerRepository.save(roleAnswerEntity);
        return roleAnswerEntity;
    }

    public AbilityAnswer saveAbilityAnswer(AbilityAnswer abilityAnswer) throws Exception {
        Ability ability = abilityDAO.getById(abilityAnswer.getAbility().getId());
        AbilityAnswer abilityAnswerEntity = AbilityAnswer.builder().ability(ability).rating(abilityAnswer.getRating()).build();
        abilityAnswerEntity = abilityAnswerRepository.save(abilityAnswerEntity);
        return abilityAnswerEntity;
    }

    public PreferMateAnswer savePreferMateAnswer(PreferMateAnswer preferMateAnswer) {
        PreferMateAnswer preferMateAnswerEntity = PreferMateAnswer.builder().studentNumber(preferMateAnswer.getStudentNumber()).build();
        return preferMateAnswerRepository.save(preferMateAnswerEntity);
    }

    public Answer save(Answer answer) throws Exception {
        return answerRepository.save(answer);
    }
}
