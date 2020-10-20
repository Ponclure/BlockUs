clear @s carrot_on_a_stick{display:{Name:'{"text":"Report","italic":"false"}'},HideFlags:63,CustomModelData:2}
execute as @s[tag=surveil] run function scripts:exit_camera
execute at @s run playsound minecraft:death master @s ~ ~ ~ 9999
scoreboard players set @s clear_blur 50
replaceitem entity @s armor.head carved_pumpkin{display:{Name:'{"text":"Death","italic":"false"}'},HideFlags:63}
tag @s add ghost
team join ghost @s