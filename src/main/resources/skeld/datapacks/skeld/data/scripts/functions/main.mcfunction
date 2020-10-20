##### IMPORTS #####
#/summon minecraft:armor_stand ~ ~ ~ {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["model"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:0}}]}
#effect give @a night_vision 9999 0 true
effect give @a jump_boost 9999 128 true
effect give @a resistance 9999 128 true
effect give @a instant_health 9999 128 true
effect give @a weakness 9999 128 true
effect give @a[team=playing] speed 2 0 true
scoreboard objectives add settings dummy {"text":"Custom Settings"}
function scripts:settings
setworldspawn -230 1 4
forceload add -205 -220 -324 -292
forceload add 0 0
forceload add -301 -300 -231 -365
execute as @e[type=item] run data merge entity @s {PickupDelay:0s}
execute as @e[type=item] at @s run tp @s @p
function scripts:inventory
function scripts:click
scoreboard objectives add var dummy
scoreboard players set ticks_per_sec var 20
#weather rain
scoreboard objectives add food food
effect give @a[scores={food=2..}] minecraft:hunger 1 127 true
effect give @a[scores={food=..3}] minecraft:saturation 1 1 true
#stopsound @a player minecraft:entity.player.big_fall
effect give @e[tag=seat_pig] invisibility 9999 0 true
function scripts:off_seat


##### MAIN #####
## Game tracking
function scripts:game_track

## Reveal impostors
title @a[tag=impostor] actionbar ["",{"text":"Impostors: ","color":"white","bold":"true"},{"selector":"@a[tag=impostor]","color":"red"}]

## Locations
execute as @a[team=playing] at @s unless block ~ ~-1 ~ netherite_block run function scripts:location
execute as @a[team=ghost] at @s unless block ~ ~-1 ~ netherite_block run function scripts:location

## Particles to reveal tasks
execute as @e[tag=incomplete,tag=!inspect_sample,scores={being_faked=0}] at @s if entity @a[distance=..4] run particle minecraft:end_rod ~ ~1.5 ~ 0.0 0.0 0.0 1.0 0
execute unless score inspect_sample inspect_sample matches 0.. as @e[tag=incomplete,tag=med_bay,tag=inspect_sample] at @s if entity @a[distance=..4] run particle minecraft:end_rod ~ ~1.5 ~ 0.0 0.0 0.0 1.0 0

execute unless score inspect_sample inspect_sample matches 1.. run clone -277 77 -254 -277 77 -254 -281 77 -256
execute if score inspect_sample inspect_sample matches 1.. run clone -278 77 -254 -278 77 -254 -281 77 -256

## TASKS
# Cafeteria, empty_garbage
execute if block -274 202 -302 lever[powered=false] run fill -279 201 -306 -275 200 -305 iron_block
execute if block -274 202 -302 lever[powered=true] run fill -279 201 -306 -275 200 -305 air

# Storage, empty_garbage
execute if block -264 202 -324 lever[powered=false] run fill -265 201 -327 -269 200 -328 iron_block
execute if block -264 202 -324 lever[powered=true] run fill -265 201 -327 -269 200 -328 air

# Storage, empty_chute
execute if block -254 202 -324 lever[powered=false] run fill -255 201 -327 -259 200 -328 iron_block
execute if block -254 202 -324 lever[powered=true] run fill -255 201 -327 -259 200 -328 air

# O2, empty_chute
execute if block -234 202 -346 lever[powered=false] run fill -235 201 -349 -239 200 -350 iron_block
execute if block -234 202 -346 lever[powered=true] run fill -235 201 -349 -239 200 -350 air

# Fuel bucket-miss check
execute if block -248 202 -304 water run function scripts:upper_engine_reset
execute if block -247 202 -304 water run function scripts:upper_engine_reset
execute if block -246 202 -304 water run function scripts:upper_engine_reset
execute if block -248 202 -305 water run function scripts:upper_engine_reset
execute if block -247 202 -305 water run function scripts:upper_engine_reset
execute if block -246 202 -305 water run function scripts:upper_engine_reset
execute if block -248 202 -306 water run function scripts:upper_engine_reset
execute if block -247 202 -306 water run function scripts:upper_engine_reset
execute if block -246 202 -306 water run function scripts:upper_engine_reset

execute if block -258 202 -315 water run function scripts:lower_engine_reset
execute if block -257 202 -315 water run function scripts:lower_engine_reset
execute if block -256 202 -315 water run function scripts:lower_engine_reset
execute if block -258 202 -316 water run function scripts:lower_engine_reset
execute if block -257 202 -316 water run function scripts:lower_engine_reset
execute if block -256 202 -316 water run function scripts:lower_engine_reset
execute if block -258 202 -317 water run function scripts:lower_engine_reset
execute if block -257 202 -317 water run function scripts:lower_engine_reset
execute if block -256 202 -317 water run function scripts:lower_engine_reset

# Med Bay
execute unless entity @e[tag=in_meeting] if score inspect_sample inspect_sample matches 1.. if block -280 77 -256 air run scoreboard players remove inspect_sample inspect_sample 1
execute if score submit_scan submit_scan matches 1.. at @e[tag=submit_scan,tag=med_bay] as @p[distance=..2.0,limit=1,sort=nearest,tag=crewmate] at @s run particle minecraft:reverse_portal ~ ~1 ~ 0.0 0.0 0.0 1.0 10 force
execute if score submit_scan submit_scan matches 1.. at @e[tag=submit_scan,tag=med_bay] as @p[distance=..2.0,limit=1,sort=nearest,tag=crewmate] at @s run particle minecraft:reverse_portal ~ ~ ~ 0.0 0.0 0.0 1.0 10 force
execute if score submit_scan submit_scan matches 1.. at @e[tag=submit_scan,tag=med_bay] as @p[distance=..2.0,limit=1,sort=nearest,tag=crewmate] at @s run effect give @s nausea 3 10 true
execute if score submit_scan submit_scan matches 1.. at @e[tag=submit_scan,tag=med_bay] as @p[distance=..2.0,limit=1,sort=nearest,tag=crewmate] at @s run scoreboard players remove submit_scan submit_scan 1
execute if score submit_scan submit_scan matches 1.. at @e[tag=submit_scan,tag=med_bay] unless entity @p[distance=..2.0,limit=1,sort=nearest,tag=crewmate] run function scripts:submit_scan_check

## Check if task is occupied
function scripts:task_occupied
function scripts:connect_bodies

## Check task success
function scripts:task_success

## Camera TP
effect give @a[tag=surveil] invisibility 2 0 true
tp @a[tag=to_c1] @e[tag=c1,limit=1]
tp @a[tag=to_c2] @e[tag=c2,limit=1]
tp @a[tag=to_c3] @e[tag=c3,limit=1]
tp @a[tag=to_c4] @e[tag=c4,limit=1]

## Check if camera is occupied
function scripts:camera_occupied
execute as @e[tag=camera] at @s if entity @p[distance=..0.1] run particle dust 1 0 0 0.25 ^0.84 ^1.5 ^-1.2 0.0 0.0 0.0 1.0 10 force

## Emergency Meeting cooldown
execute if score e_meeting_cd game_track matches 1.. run scoreboard players remove e_meeting_cd game_track 1

## Check meeting
execute if score e_meetings game_track < EmergencyMeetings settings if score e_meeting_cd game_track matches 0 if score o2 sabotage matches -1 if score reactor sabotage matches -1 if score comms sabotage matches -1 if score lights sabotage matches -1 unless entity @e[tag=report_body] run particle dust -1 1 0 0.5 -258.0 77.5 -273.00 0.0 0.0 0.0 1.0 10 force
execute if entity @e[tag=SKIP,tag=eject] run function scripts:meeting/result_skipped
execute if entity @e[tag=!SKIP,tag=eject] run function scripts:meeting/result_ejected

## Kill cooldown
execute as @a[tag=impostor,tag=!venting,tag=!surveil] if score @s kill_cd matches 1.. run scoreboard players remove @s kill_cd 1

## Clear blur
execute as @a[tag=crewmate] if score @s clear_blur matches 1.. run scoreboard players remove @s clear_blur 1
execute as @a[tag=crewmate] if score @s clear_blur matches 0 run replaceitem entity @s armor.head air

## Ghost movement
function scripts:ghost

## Vent TP
effect give @a[tag=venting] invisibility 2 0 true
function scripts:venting_system

## Fake mechanic
scoreboard players remove @e[scores={faked=1..}] faked 1
scoreboard players set @e[scores={faked=1}] being_faked 600
scoreboard players remove @e[scores={being_faked=1..}] being_faked 1

## Disable cameras if comms down
execute if score comms sabotage matches 0.. run title @a[tag=surveil] title {"text":""}
execute if score comms sabotage matches 0.. run title @a[tag=surveil] subtitle {"text":"Comms are down"}
execute if score comms sabotage matches 0.. run effect clear @a[tag=surveil] invisibility
execute if score comms sabotage matches 0.. run execute as @a[tag=surveil] run function scripts:exit_camera
execute if score comms sabotage matches -1 unless entity @e[nbt={Motive:"minecraft:donkey_kong"}] run kill @e[nbt={Motive:"minecraft:skeleton"}]
execute if score comms sabotage matches -1 unless entity @e[nbt={Motive:"minecraft:donkey_kong"}] run summon minecraft:painting -292 78 -263 {Motive:"minecraft:donkey_kong"}
execute if score comms sabotage matches 0.. unless entity @e[nbt={Motive:"minecraft:skeleton"}] run kill @e[nbt={Motive:"minecraft:donkey_kong"}]
execute if score comms sabotage matches 0.. unless entity @e[nbt={Motive:"minecraft:skeleton"}] run summon minecraft:painting -292 78 -263 {Motive:"minecraft:skeleton"}


## Sabotage cooldown
execute if score cd sabotage matches 1.. unless entity @a[tag=impostor,tag=venting] unless entity @a[tag=impostor,tag=surveil] run scoreboard players remove cd sabotage 1
execute if score cd_doors sabotage matches 1.. unless entity @a[tag=impostor,tag=venting] unless entity @a[tag=impostor,tag=surveil] run scoreboard players remove cd_doors sabotage 1

## Sabotage displays
execute if score o2 sabotage matches -1 if score reactor sabotage matches -1 run worldborder warning distance 0

execute if score o2 sabotage matches 0.. run function scripts:sabotage_display_o2
execute if score o2 sabotage matches 0.. run execute store result bossbar minecraft:o2 value run scoreboard players get o2 sabotage
execute if score o2 sabotage matches -1 run bossbar set minecraft:o2 players
execute if score o2 sabotage matches 0..200 run worldborder warning distance 2000000000
function scripts:o2_fix

execute if score reactor sabotage matches 0.. run function scripts:sabotage_display_reactor
execute if score reactor sabotage matches 0.. run execute store result bossbar minecraft:reactor value run scoreboard players get reactor sabotage
execute if score reactor sabotage matches -1 run bossbar set minecraft:reactor players
execute if score reactor sabotage matches 0..200 run worldborder warning distance 2000000000
function scripts:reactor_fix

execute if score o2 sabotage matches 0.. run execute as @e[tag=o2_alert] run data merge entity @s {Glowing:1b}
execute if score reactor sabotage matches 0.. run execute as @e[tag=reactor_alert] run data merge entity @s {Glowing:1b}
execute if score reactor sabotage matches 0.. run execute as @e[tag=reactor_alert] run fill -317 77 -257 -318 80 -258 minecraft:red_stained_glass
execute if score lights sabotage matches 0.. run execute as @e[tag=lights_alert] run data merge entity @s {Glowing:1b}
execute if score comms sabotage matches 0.. run execute as @e[tag=comms_alert] run data merge entity @s {Glowing:1b}
execute if score o2 sabotage matches -1 run execute as @e[tag=o2_alert] run data merge entity @s {Glowing:0b}
execute if score reactor sabotage matches -1 run execute as @e[tag=reactor_alert] run data merge entity @s {Glowing:0b}
execute if score reactor sabotage matches -1 run execute as @e[tag=reactor_alert] run fill -317 77 -257 -318 80 -258 minecraft:white_stained_glass
execute if score lights sabotage matches -1 run execute as @e[tag=lights_alert] run data merge entity @s {Glowing:0b}
execute if score comms sabotage matches -1 run execute as @e[tag=comms_alert] run data merge entity @s {Glowing:0b}

## Sabotage timers
execute if score o2 sabotage matches 1.. run scoreboard players remove o2 sabotage 1
execute if score reactor sabotage matches 1.. run scoreboard players remove reactor sabotage 1

scoreboard players add comms_anim sabotage 1
execute if score comms_anim sabotage matches 61.. run scoreboard players set comms_anim sabotage 0
execute if score comms_anim sabotage matches 1 run setblock -249 78 -223 quartz_block
execute if score comms_anim sabotage matches 1 run setblock -244 78 -223 minecraft:lime_concrete_powder
execute if score comms_anim sabotage matches 11 run setblock -244 78 -223 quartz_block
execute if score comms_anim sabotage matches 11 run setblock -245 78 -223 minecraft:lime_concrete_powder
execute if score comms_anim sabotage matches 21 run setblock -245 78 -223 quartz_block
execute if score comms_anim sabotage matches 21 run setblock -246 78 -223 minecraft:lime_concrete_powder
execute if score comms_anim sabotage matches 31 run setblock -246 78 -223 quartz_block
execute if score comms_anim sabotage matches 31 run setblock -247 78 -223 minecraft:lime_concrete_powder
execute if score comms_anim sabotage matches 41 run setblock -247 78 -223 quartz_block
execute if score comms_anim sabotage matches 41 run setblock -248 78 -223 minecraft:lime_concrete_powder
execute if score comms_anim sabotage matches 51 run setblock -248 78 -223 quartz_block
execute if score comms_anim sabotage matches 51 run setblock -249 78 -223 minecraft:lime_concrete_powder
execute if block -247 77 -224 stone_button[face=floor,facing=south,powered=true] run function scripts:comms_fix

execute if score lights sabotage matches 1.. unless entity @e[tag=in_meeting] run effect give @a[tag=crewmate,tag=!ghost] blindness 2 0 true
function scripts:lights_fix

execute as @e[tag=door] if score @s close_door matches 1.. run scoreboard players remove @s close_door 1
execute as @e[tag=door] if score @s close_door matches 1.. at @s run fill ~ ~ ~ ~ ~2 ~ iron_block replace air
execute as @e[tag=door] if score @s close_door matches 0 at @s run fill ~ ~ ~ ~ ~2 ~ air replace iron_block

execute as @e[tag=door] if score @s close_door matches 199 at @s run playsound minecraft:block.piston.extend master @a ~ ~ ~ 1 0.5
execute as @e[tag=door] if score @s close_door matches 2 at @s run playsound minecraft:block.piston.contract master @a ~ ~ ~ 1 0.5

## Check if game ends
execute if score o2 sabotage matches 0 run function scripts:game_check
execute if score reactor sabotage matches 0 run function scripts:game_check
execute if entity @e[tag=task] unless entity @e[tag=incomplete] run function scripts:crewmate_win

## Sprite in admin map
function scripts:sprites_map


## Fail-safe if no tasks left but bar is not full?

## Vote UI
function scripts:vote_confirm
execute if entity @a[tag=in_meeting] unless entity @a[scores={vote_id=-1}] run function scripts:vote_count

## Vote timer
execute if score timer vote_timer matches 1.. run scoreboard players remove timer vote_timer 1
execute store result bossbar minecraft:vote_timer value run scoreboard players get timer vote_timer
execute if score timer vote_timer matches 0 run function scripts:voting_runout

