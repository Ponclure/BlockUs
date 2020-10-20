execute as @a[tag=surveil] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Exit","italic":"false"}'},HideFlags:63,CustomModelData:1}}} if score @s click matches 1.. run function scripts:exit_camera
execute as @a[tag=impostor] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Kill","italic":"false"}'},HideFlags:63,CustomModelData:3}}} if score @s click matches 1.. run function scripts:kill
execute as @a at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Report","italic":"false"}'},HideFlags:63,CustomModelData:2}}} if score @s click matches 1.. run function scripts:report_body

execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Vent","italic":"false"}'},HideFlags:63,CustomModelData:5}}} if score @s click matches 1.. run function scripts:vent
execute as @a[tag=impostor,tag=venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Vent","italic":"false"}'},HideFlags:63,CustomModelData:5}}} if score @s click matches 1.. run function scripts:exit_vent
execute as @a[tag=impostor,tag=venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Move","italic":"false"}'},HideFlags:63,CustomModelData:6}}} if score @s click matches 1.. run function scripts:vent_move

execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Sabotage O2","italic":"false"}'},HideFlags:63,CustomModelData:9}}} if score @s click matches 1.. run function scripts:sabotage/o2
execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Sabotage Reactor","italic":"false"}'},HideFlags:63,CustomModelData:10}}} if score @s click matches 1.. run function scripts:sabotage/reactor
execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Sabotage Comms","italic":"false"}'},HideFlags:63,CustomModelData:11}}} if score @s click matches 1.. run function scripts:sabotage/comms
execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Sabotage Lights","italic":"false"}'},HideFlags:63,CustomModelData:12}}} if score @s click matches 1.. run function scripts:sabotage/lights
execute as @a[tag=impostor,tag=!venting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Sabotage Doors","italic":"false"}'},HideFlags:63,CustomModelData:13}}} if score @s click matches 1.. run function scripts:sabotage/doors

execute as @a[tag=crewmate,tag=!in_meeting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Locate Task","italic":"false"}'},HideFlags:63,CustomModelData:14}}} if score @s click matches 1.. run function scripts:locate_task
execute as @a[tag=impostor,tag=!in_meeting] at @s if data entity @s {SelectedItem:{tag:{display:{Name:'{"text":"Locate Task","italic":"false"}'},HideFlags:63,CustomModelData:14}}} if score @s click matches 1.. run function scripts:locate_task


scoreboard players reset @a click