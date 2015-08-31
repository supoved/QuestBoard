package com.supoved.questboard.data;


import com.supoved.questboard.data.models.Quest;

import java.util.ArrayList;

public class QuestStorage {

    protected ArrayList<Quest> quests;

    public QuestStorage(){
        this.initTestData();
    }

    private void initTestData() {
        this.quests = new ArrayList<>();
        quests.add(addTestQuest("Fix bicycle tire", "Bicycle tyre has a hole, need to disassemble it and fix"));
        quests.add(addTestQuest("Add active quest list UI", "Need to display list of active quests"));
        quests.add(addTestQuest("Add available quest list UI", "Need to display list of all available quests"));
    }

    private Quest addTestQuest(String title, String description){
        Quest quest = new Quest();
        quest.description = description;
        quest.title = title;
        return quest;
    }

    public Quest[] getActiveQuests(){
        return quests.toArray(new Quest[quests.size()]);
    }
}
