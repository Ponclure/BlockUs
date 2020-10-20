execute if score ConfirmEjects settings matches 1 run tellraw @a ["",{"text":"Impostors left: ","color":"red"},{"score":{"name":"impostors_alive","objective":"game_track"}}]

execute as @a[tag=fling] at @s run function scripts:spread_to_cafeteria
tag @a[tag=fling] remove fling

## Check if game ends
execute as @a at @s run playsound minecraft:main_ambience master @s ~ ~ ~ 9999
schedule function scripts:game_check 1s