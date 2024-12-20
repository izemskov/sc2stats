package ru.develgame.sc2stats.composer;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import ru.develgame.sc2stats.entity.SC2Daily;
import ru.develgame.sc2stats.entity.SC2Match;
import ru.develgame.sc2stats.service.DailyServiceImpl;
import ru.develgame.sc2stats.service.MatchServiceImpl;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class IndexComposer extends SelectorComposer<Div> {
    @Wire
    private Listbox matchesList;

    @Wire
    private Listbox dailyList;

    @WireVariable
    private MatchServiceImpl matchServiceImpl;

    @WireVariable
    private DailyServiceImpl dailyServiceImpl;

    private ListModelList<SC2Match> matchesDataModel = new ListModelList<>();

    private ListModelList<SC2Daily> dailyDataModel = new ListModelList<>();

    @Override
    public void doAfterCompose(Div comp) throws Exception {
        super.doAfterCompose(comp);

        matchesDataModel = new ListModelList<>(matchServiceImpl.fetchAllMatchesSortedByDateDesc());
        matchesList.setModel(matchesDataModel);

        dailyDataModel = new ListModelList<>(dailyServiceImpl.fetchAllSortedByDateDesc());
        dailyList.setModel(dailyDataModel);
    }
}
