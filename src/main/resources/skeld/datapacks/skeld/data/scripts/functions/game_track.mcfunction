##### IMPORTS #####
scoreboard objectives add game_track dummy
execute unless score stage game_track matches 0.. run scoreboard players set stage game_track 0
bossbar add completion {"text":"TOTAL TASKS COMPLETED","color":"green"}
bossbar set minecraft:completion style notched_20
bossbar set minecraft:completion color green
scoreboard players set players game_track 0
execute as @a run scoreboard players add players game_track 1

# To false-start game:
#scoreboard players set players game_track 10

scoreboard players set impostors_alive game_track 0
execute as @a[tag=impostor,tag=!ghost] run scoreboard players add impostors_alive game_track 1
scoreboard players set crewmates_alive game_track 0
execute as @a[tag=crewmate,tag=!ghost] run scoreboard players add crewmates_alive game_track 1


##### MAIN #####
## Standby
execute if score stage game_track matches 0 run tag @a remove crewmate
execute if score stage game_track matches 0 run tag @a remove impostor
execute if score stage game_track matches 0 run bossbar set minecraft:completion players

## Bossbar
scoreboard objectives add bossbar_timer dummy
scoreboard players add timer bossbar_timer 1
execute if score timer bossbar_timer matches 20.. run scoreboard players set timer bossbar_timer 0
execute if score timer bossbar_timer matches 0 run function scripts:randomisers/13

execute if score stage game_track matches 1 run bossbar set minecraft:completion players @a
execute if score timer bossbar_timer matches 0 if score var bossbar_timer matches 0..3 if score comms sabotage matches -1 store result bossbar minecraft:completion value run scoreboard players get completed_tasks game_track

# Sabotage
execute unless score comms sabotage matches -1 run bossbar set minecraft:completion value 0
