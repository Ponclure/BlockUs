tp @a[tag=eject] ~ 2000000 ~
tag @a[tag=eject] add fling

effect give @a blindness 6 0 true
effect clear @a slowness
effect give @a slowness 5 127 true

title @a title {"text":""}
execute if score ConfirmEjects settings matches 0 run title @a subtitle ["",{"selector":"@e[tag=eject]"},{"text":" was ejected."}]
execute if score ConfirmEjects settings matches 1 if entity @e[tag=eject,tag=crewmate] run title @a subtitle ["",{"selector":"@e[tag=eject]"},{"text":" was not An Impostor."}]
execute if score ConfirmEjects settings matches 1 if entity @e[tag=eject,tag=impostor] run title @a subtitle ["",{"selector":"@e[tag=eject]"},{"text":" was An Impostor."}]
execute as @a at @s run playsound minecraft:generic master @s ~ ~ ~ 9999

scoreboard players operation e_meeting_cd game_track = EmergencyMeetingCDSec settings
scoreboard players operation e_meeting_cd game_track *= ticks_per_sec var
scoreboard players add e_meeting_cd game_track 60

tag @e[tag=eject] add ghost
team join ghost @e[tag=eject]

tag @e remove eject
tag @a remove report_body
tag @a remove in_meeting
function scripts:default_cd

schedule function scripts:announce_imposters_left 3s
