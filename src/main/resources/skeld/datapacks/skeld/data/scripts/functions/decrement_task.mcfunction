scoreboard players remove @s increment_task 1
execute if score @s increment_task matches 0 run tag @s remove incomplete
scoreboard players add completed_tasks game_track 1