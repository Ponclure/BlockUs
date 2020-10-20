#execute as @a run replaceitem entity @s hotbar.7 barrier
execute as @a run replaceitem entity @s[scores={location=1}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:15} 1
execute as @a run replaceitem entity @s[scores={location=2}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:16} 1
execute as @a run replaceitem entity @s[scores={location=3}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:17} 1
execute as @a run replaceitem entity @s[scores={location=4}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:18} 1
execute as @a run replaceitem entity @s[scores={location=5}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:19} 1
execute as @a run replaceitem entity @s[scores={location=6}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:20} 1
execute as @a run replaceitem entity @s[scores={location=7}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:21} 1
execute as @a run replaceitem entity @s[scores={location=8}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:22} 1
execute as @a run replaceitem entity @s[scores={location=9}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:23} 1
execute as @a run replaceitem entity @s[scores={location=10}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:24} 1
execute as @a run replaceitem entity @s[scores={location=11}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:25} 1
execute as @a run replaceitem entity @s[scores={location=12}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:26} 1
execute as @a run replaceitem entity @s[scores={location=13}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:27} 1
execute as @a run replaceitem entity @s[scores={location=14}] hotbar.7 carrot_on_a_stick{display:{Name:'{"text":"The Skeld","italic":"false"}'},HideFlags:63,CustomModelData:28} 1

## Cams
#replaceitem entity @a[tag=surveil] weapon.offhand barrier
#replaceitem entity @a[tag=surveil] hotbar.0 barrier
#replaceitem entity @a[tag=surveil] hotbar.1 barrier
#replaceitem entity @a[tag=surveil] hotbar.2 barrier
#replaceitem entity @a[tag=surveil] hotbar.3 barrier
#replaceitem entity @a[tag=surveil] hotbar.4 barrier
#replaceitem entity @a[tag=surveil] hotbar.5 barrier
#replaceitem entity @a[tag=surveil] hotbar.6 barrier
#replaceitem entity @a[tag=surveil] hotbar.7 barrier
replaceitem entity @a[tag=surveil] hotbar.8 carrot_on_a_stick{display:{Name:'{"text":"Exit","italic":"false"}'},HideFlags:63,CustomModelData:1} 1

## Crewmate
replaceitem entity @a[tag=crewmate] weapon.offhand air
replaceitem entity @a[tag=crewmate,tag=!surveil] hotbar.8 barrier
execute as @a[tag=crewmate,tag=!surveil,tag=!ghost] at @s positioned ~ ~1.62 ~ positioned ^ ^ ^2.5 unless entity @e[tag=body,distance=..2] run replaceitem entity @s hotbar.0 barrier
execute as @a[tag=crewmate,tag=!surveil,tag=!ghost,tag=!in_meeting] at @s positioned ~ ~1.62 ~ positioned ^ ^ ^2.5 if entity @e[tag=body,distance=..2] run replaceitem entity @s hotbar.0 carrot_on_a_stick{display:{Name:'{"text":"Report","italic":"false"}'},HideFlags:63,CustomModelData:2} 1
execute as @a[tag=crewmate,tag=in_meeting] run replaceitem entity @s hotbar.1 barrier
execute as @a[tag=crewmate,tag=!in_meeting] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Locate Task","italic":"false"}'},HideFlags:63,CustomModelData:14} 1

## Impostor
replaceitem entity @a[tag=impostor] weapon.offhand air
execute as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s positioned ~ ~1.62 ~ positioned ^ ^ ^2.5 unless entity @e[tag=body,distance=..2] run replaceitem entity @s hotbar.0 barrier
execute as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s if score @s kill_cd matches 1.. run replaceitem entity @s hotbar.1 barrier
execute as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!in_meeting] at @s positioned ~ ~1.62 ~ positioned ^ ^ ^2.5 if entity @e[tag=body,distance=..2] run replaceitem entity @s hotbar.0 carrot_on_a_stick{display:{Name:'{"text":"Report","italic":"false"}'},HideFlags:63,CustomModelData:2} 1
execute if score KillDistance settings matches 0 as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s unless entity @a[tag=crewmate,distance=..3] run replaceitem entity @s hotbar.1 barrier
execute if score KillDistance settings matches 1 as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s unless entity @a[tag=crewmate,distance=..4] run replaceitem entity @s hotbar.1 barrier
execute if score KillDistance settings matches 2 as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s unless entity @a[tag=crewmate,distance=..5] run replaceitem entity @s hotbar.1 barrier
execute if score KillDistance settings matches 0 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @a[tag=crewmate,tag=!ghost,tag=!surveil,distance=..3] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute if score KillDistance settings matches 1 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @a[tag=crewmate,tag=!ghost,tag=!surveil,distance=..4] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute if score KillDistance settings matches 2 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @a[tag=crewmate,tag=!ghost,tag=!surveil,distance=..5] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute if score KillDistance settings matches 0 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..3] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute if score KillDistance settings matches 1 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..4] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute if score KillDistance settings matches 2 as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!venting,tag=!in_meeting] at @s if score @s kill_cd matches 0 if entity @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..5] run replaceitem entity @s hotbar.1 carrot_on_a_stick{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3} 1
execute as @a[tag=impostor,tag=in_meeting] at @s run replaceitem entity @s hotbar.1 barrier
execute as @a[tag=impostor,tag=!surveil,tag=!ghost] at @s unless block ~ ~-1 ~ iron_trapdoor run replaceitem entity @s hotbar.2 barrier
execute as @a[tag=impostor,tag=!surveil,tag=!ghost,tag=!in_meeting] at @s if block ~ ~-1 ~ minecraft:iron_trapdoor[open=false] run replaceitem entity @s hotbar.2 carrot_on_a_stick{display:{Name:'{"text":"Vent","italic":"false"}'},HideFlags:63,CustomModelData:5} 1
execute as @a[tag=impostor,tag=!venting,tag=!surveil] run replaceitem entity @s hotbar.3 barrier
execute as @a[tag=impostor,tag=venting,tag=!in_meeting,tag=!surveil] run replaceitem entity @s hotbar.3 carrot_on_a_stick{display:{Name:'{"text":"Move","italic":"false"}'},HideFlags:63,CustomModelData:6} 1
execute as @a[tag=impostor,tag=in_meeting] run replaceitem entity @s hotbar.4 barrier
execute as @a[tag=impostor,tag=!in_meeting] run replaceitem entity @s hotbar.4 carrot_on_a_stick{display:{Name:'{"text":"Locate Task","italic":"false"}'},HideFlags:63,CustomModelData:14} 1

#replaceitem entity @a[tag=impostor] hotbar.5 air
#replaceitem entity @a[tag=impostor] hotbar.6 air
#replaceitem entity @a[tag=impostor] hotbar.7 air
replaceitem entity @a[tag=impostor,tag=!surveil] hotbar.8 barrier


execute unless score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!surveil] inventory.0 barrier
execute unless score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!surveil] inventory.1 barrier
execute unless score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!surveil] inventory.2 barrier
execute unless score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!surveil] inventory.3 barrier
execute unless score cd_doors sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!surveil] inventory.4 barrier

replaceitem entity @a[tag=impostor,tag=venting] inventory.0 barrier
replaceitem entity @a[tag=impostor,tag=venting] inventory.1 barrier
replaceitem entity @a[tag=impostor,tag=venting] inventory.2 barrier
replaceitem entity @a[tag=impostor,tag=venting] inventory.3 barrier
replaceitem entity @a[tag=impostor,tag=venting] inventory.4 barrier

execute if score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!venting,tag=!surveil,tag=!in_meeting] inventory.0 carrot_on_a_stick{display:{Name:'{"text":"Sabotage O2","italic":"false"}'},HideFlags:63,CustomModelData:9} 1
execute if score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!venting,tag=!surveil,tag=!in_meeting] inventory.1 carrot_on_a_stick{display:{Name:'{"text":"Sabotage Reactor","italic":"false"}'},HideFlags:63,CustomModelData:10} 1
execute if score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!venting,tag=!surveil,tag=!in_meeting] inventory.2 carrot_on_a_stick{display:{Name:'{"text":"Sabotage Comms","italic":"false"}'},HideFlags:63,CustomModelData:11} 1
execute if score cd sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!venting,tag=!surveil,tag=!in_meeting] inventory.3 carrot_on_a_stick{display:{Name:'{"text":"Sabotage Lights","italic":"false"}'},HideFlags:63,CustomModelData:12} 1
execute if score cd_doors sabotage matches 0 run replaceitem entity @a[tag=impostor,tag=!venting,tag=!surveil,tag=!in_meeting] inventory.4 carrot_on_a_stick{display:{Name:'{"text":"Sabotage Doors","italic":"false"}'},HideFlags:63,CustomModelData:13} 1

