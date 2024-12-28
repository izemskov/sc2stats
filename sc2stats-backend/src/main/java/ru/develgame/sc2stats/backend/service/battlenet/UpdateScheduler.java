package ru.develgame.sc2stats.backend.service.battlenet;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnExpression("${sc.update.enable:false}")
public class UpdateScheduler {
//    private final UpdateSC2MatchHistoryService updateSC2MatchHistoryService;
//    private final UpdateSC2PlayerInfo updateSC2PlayerInfo;
//    private final BattleNetUpdateDateService battleNetUpdateDateService;
    private final BattleNetApiAuthService battleNetApiAuthService;

    @Scheduled(fixedRateString = "3600000", initialDelayString = "5000")
    public void updateSC2MatchHistory() {
        String accessToken = battleNetApiAuthService.getAccessToken();
//
//        updateSC2MatchHistoryService.updateSC2MatchHistory(accessToken);
//        updateSC2PlayerInfo.updateSC2PlayerInfo(accessToken);
//
//        battleNetUpdateDateService.updateLastUpdateDate();
    }
}