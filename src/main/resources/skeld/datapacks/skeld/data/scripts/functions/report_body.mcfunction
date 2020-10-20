## End O2/Reactor sabotages
scoreboard players set cd sabotage 340
scoreboard players set reactor sabotage -1
scoreboard players set o2 sabotage -1
execute as @e[tag=o2_sabotage] at @s run setblock ~ ~ ~ lever[face=wall,facing=south,powered=true]

## Move all players
execute as @a[tag=surveil] run function scripts:exit_camera
execute as @a[tag=venting] run function scripts:exit_vent
execute as @a at @s run function scripts:spread_to_cafeteria
effect clear @a[tag=impostor,tag=!ghost] invisibility
effect give @a slowness 9999 127 true

## Title/sound
title @a title ["",{"text":"÷"},{"text":"Dead Body Reported","color":"red"}]
title @a subtitle {"text":"Discuss!","color":"none"}
execute as @a at @s run playsound minecraft:report_body master @s ~ ~ ~ 9999

## Deaths
tellraw @a {"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"}
tellraw @a {"text":" -----------------------------","color":"gray"}
tellraw @a ["",{"text":" `"},{"selector":"@s","color":"yellow"}]
execute if entity @e[tag=ghost] run tellraw @a ["",{"text":" X: ","bold":true,"color":"red"},{"selector":"@a[tag=ghost]","color":"gray"}]

## UI
function scripts:vote_ui

kill @e[tag=body]
function scripts:reset_tasks_xsample

tag @a add report_body
tag @a add in_meeting
clear @a
execute as @a at @s run stopsound @s master minecraft:main_ambience
team modify playing nametagVisibility always

## Fail-safe
effect give @a[tag=ghost] invisibility 9999 0 true