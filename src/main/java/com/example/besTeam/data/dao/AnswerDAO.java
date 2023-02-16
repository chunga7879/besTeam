package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.AbilityAnswer;
import com.example.besTeam.data.entity.Answer;
import com.example.besTeam.data.entity.PreferMateAnswer;
import com.example.besTeam.data.entity.RoleAnswer;

public interface AnswerDAO {
    Answer save(Answer answer) throws Exception;

    PreferMateAnswer savePreferMateAnswer(PreferMateAnswer preferMateAnswer);

    RoleAnswer saveRoleAnswer(RoleAnswer roleAnswer) throws Exception;

    AbilityAnswer saveAbilityAnswer(AbilityAnswer abilityAnswer) throws Exception;
}
