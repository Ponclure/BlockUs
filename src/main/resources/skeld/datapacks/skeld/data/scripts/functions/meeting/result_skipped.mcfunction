effect give @a blindness 6 0 true
effect clear @a slowness
effect give @a slowness 5 127 true

title @a title {"text":""}
title @a subtitle {"text":"No one was ejected."}
execute as @a at @s run playsound minecraft:generic master @s ~ ~ ~ 9999

scoreboard players operation e_meeting_cd game_track = EmergencyMeetingCDSec settings
scoreboard players operation e_meeting_cd game_track *= ticks_per_sec var
scoreboard players add e_meeting_cd game_track 60

tag @e remove eject
tag @a remove report_body
tag @a remove in_meeting
function scripts:default_cd

schedule function scripts:announce_imposters_left 3s