##### IMPORTS #####
function scripts:build
clear @a
team join playing @a
scoreboard objectives setdisplay sidebar
function scripts:player_id


##### MAIN #####
execute if score Impostors settings matches 1 run tag @a[limit=1,sort=random] add impostor
execute if score Impostors settings matches 2 run tag @a[limit=2,sort=random] add impostor
execute if score Impostors settings matches 3 run tag @a[limit=3,sort=random] add impostor
tag @a[tag=!impostor] add crewmate

function scripts:reset_tasks
scoreboard players set stage game_track 1

## Display/sound
effect give @a blindness 7 0 true
effect give @a slowness 6 127 true

#tellraw @a {"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"}
title @a title {"text":"√SHHHHHHH!"}
title @a[tag=impostor] subtitle {"text":"Impostor","color":"red"}
title @a[tag=crewmate] subtitle {"text":"Crewmate","color":"aqua"}

execute if score Impostors settings matches 1 run title @a[tag=crewmate] actionbar ["",{"text":"There is "},{"score":{"name":"Impostors","objective":"settings"},"color":"red"},{"text":" Impostor","color":"red"},{"text":" among us"}]
execute if score Impostors settings matches 2..3 run title @a[tag=crewmate] actionbar ["",{"text":"There are "},{"score":{"name":"Impostors","objective":"settings"},"color":"red"},{"text":" Impostors","color":"red"},{"text":" among us"}]

execute as @a at @s run playsound minecraft:shhhhhhh master @s


## Set scores
scoreboard players set completed_tasks game_track 0
scoreboard players set impostors game_track 0
execute as @a[tag=impostor] run scoreboard players add impostors game_track 1
scoreboard players set crewmates game_track 0
execute as @a[tag=crewmate] run scoreboard players add crewmates game_track 1
scoreboard players set e_meetings game_track 0
scoreboard players set e_meeting_cd game_track 300
scoreboard objectives add kill_cd dummy
scoreboard objectives add clear_blur dummy
scoreboard players set @a[tag=crewmate] clear_blur 0
scoreboard objectives add sabotage dummy
scoreboard players set o2 sabotage -1
scoreboard players set reactor sabotage -1
scoreboard players set lights sabotage -1
scoreboard players set comms sabotage -1
function scripts:default_cd
scoreboard objectives add vote_timer dummy
scoreboard players set timer vote_timer -1
scoreboard objectives add being_faked dummy

## Bossbar
scoreboard players operation total_tasks game_track = LongTasks settings
scoreboard players operation total_tasks game_track += LongTasks settings
scoreboard players operation total_tasks game_track += ShortTasks settings
#scoreboard players operation total_tasks game_track *= crewmates game_track
# Needs another multiplier? Or not?
execute store result bossbar minecraft:completion max run scoreboard players get total_tasks game_track

## Select tasks
function scripts:select_tasks

## Spread to main
execute as @a at @s run function scripts:spread_to_cafeteria

## Start ambience
execute as @a at @s run playsound minecraft:main_ambience master @s ~ ~ ~ 9999

