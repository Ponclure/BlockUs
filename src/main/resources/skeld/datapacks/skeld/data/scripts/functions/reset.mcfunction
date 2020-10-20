gamemode adventure @a
kill @e[tag=task]
team leave @a
execute as @a[tag=surveil] run function scripts:exit_camera
execute as @a[tag=venting] run function scripts:exit_vent
function scripts:reset_trapdoors
scoreboard players reset *
tag @a remove ghost
tag @e remove eject
tag @e remove report_body
tag @a remove in_meeting
spreadplayers -230 5 0 3 under 1 false @a
schedule function scripts:clear 1s
effect clear @a
kill @e[tag=body]
worldborder warning distance 0
bossbar set minecraft:o2 players
bossbar set minecraft:reactor players
tag @e remove close_door
tag @a[tag=fling] remove fling
scoreboard objectives setdisplay sidebar settings
execute as @a at @s run stopsound @s master minecraft:main_ambience
bossbar set minecraft:vote_timer players
tag @a remove abstain
execute as @e run data merge entity @s {Glowing:0b}