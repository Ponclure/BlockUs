## Edit Values
execute unless score Impostors settings matches 0..3 run scoreboard players set Impostors settings 1
execute unless score LongTasks settings matches 0.. run scoreboard players set LongTasks settings 3
execute unless score ShortTasks settings matches 0.. run scoreboard players set ShortTasks settings 5
execute unless score EmergencyMeetings settings matches 0.. run scoreboard players set EmergencyMeetings settings 3
execute unless score EmergencyMeetingCDSec settings matches 0.. run scoreboard players set EmergencyMeetingCDSec settings 20
execute unless score ConfirmEjects settings matches 0..1 run scoreboard players set ConfirmEjects settings 0
execute unless score KillDistance settings matches 0..2 run scoreboard players set KillDistance settings 1
execute unless score KillCDSec settings matches 10..60 run scoreboard players set KillCDSec settings 20
execute unless score VotingTimeSec settings matches 30..120 run scoreboard players set VotingTimeSec settings 120



## Limits
execute if score LongTasks settings matches 11.. run scoreboard players set LongTasks settings 11
execute if score ShortTasks settings matches 17.. run scoreboard players set ShortTasks settings 17