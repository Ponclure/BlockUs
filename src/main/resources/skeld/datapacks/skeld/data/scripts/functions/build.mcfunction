scoreboard objectives add click minecraft.used:minecraft.carrot_on_a_stick
kill @e[tag=task]
kill @e[tag=camera]
kill @e[tag=camera_marker]
kill @e[tag=SKIP_detect]
kill @e[tag=vent]
kill @e[tag=o2_sabotage]
kill @e[tag=door]
kill @e[tag=model]
kill @e[tag=alert]
team add playing
team modify playing nametagVisibility never
team modify playing seeFriendlyInvisibles false
team modify playing collisionRule never
team add ghost
team modify ghost nametagVisibility never
team modify ghost seeFriendlyInvisibles true
team modify ghost collisionRule never
team add alert
team modify alert color red
gamemode adventure @a
kill @e[tag=cafeteria_spawn]
kill @e[tag=camera_model]
execute as @e[type=item_frame] run data merge entity @s {Invisible:1,Fixed:1}
gamerule sendCommandFeedback false


## Task-markers
#https://twitter.com/sirsalzig/status/1304390431288045568
#https://u.cubeupload.com/SuperInky/skeldmapguidev2.png
# Cafeteria
summon minecraft:armor_stand -270 76 -285 {CustomName:'{"text":"Cafeteria"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","cafeteria"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -249 76 -287 {CustomName:'{"text":"Cafeteria"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","upload_data","cafeteria"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -245 76 -283 {CustomName:'{"text":"Cafeteria"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","empty_garbage","cafeteria"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}

# Upper Engine
summon minecraft:armor_stand -304 76 -279 {CustomName:'{"text":"Upper Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","upper_engine"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -308 76 -270 {CustomName:'{"text":"Upper Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","align_engine","upper_engine"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}
summon minecraft:armor_stand -306 76 -271 {CustomName:'{"text":"Upper Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","fuel","upper_engine"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}

# Reactor
summon minecraft:armor_stand -309 76 -263 {CustomName:'{"text":"Reactor"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","reactor"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}
summon minecraft:armor_stand -312 76 -266 {CustomName:'{"text":"Reactor"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","unlock_manifolds","reactor"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -317 76 -255 {CustomName:'{"text":"Reactor"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","start_reactor","reactor"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}

# Lower Engine
summon minecraft:armor_stand -306 76 -245 {CustomName:'{"text":"Lower Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","lower_engine"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -307 76 -235 {CustomName:'{"text":"Lower Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","align_engine","lower_engine"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}
summon minecraft:armor_stand -306 76 -237 {CustomName:'{"text":"Lower Engine"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","fuel","lower_engine"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}

# Security
summon minecraft:armor_stand -299 76 -258 {CustomName:'{"text":"Security"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","security"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -289 76 -260 {CustomName:'{"text":"Security"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","security"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}

# Med Bay
summon minecraft:armor_stand -280 76 -256 {CustomName:'{"text":"Med Bay"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","inspect_sample","med_bay"],DisabledSlots:4144959,CustomNameVisible:0b}
summon minecraft:armor_stand -274 77 -257 {CustomName:'{"text":"Med Bay"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","submit_scan","med_bay"],DisabledSlots:4144959,CustomNameVisible:0b}

# Storage
summon minecraft:armor_stand -261 76 -247 {CustomName:'{"text":"Storage"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","storage"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -265 76 -234 {CustomName:'{"text":"Storage"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","fuel1","storage"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -265 76 -238 {CustomName:'{"text":"Storage"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","fuel2","storage"],DisabledSlots:4144959,CustomNameVisible:0b}
summon minecraft:armor_stand -258 76 -224 {CustomName:'{"text":"Storage"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","empty_garbage","storage"],DisabledSlots:4144959,CustomNameVisible:0b}
summon minecraft:armor_stand -263 76 -224 {CustomName:'{"text":"Storage"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","empty_chute","storage"],DisabledSlots:4144959,CustomNameVisible:0b}

# Electrical
summon minecraft:armor_stand -273 76 -250 {CustomName:'{"text":"Electrical"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","calibrate","electrical"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -277 76 -250 {CustomName:'{"text":"Electrical"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","electrical"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -282 76 -250 {CustomName:'{"text":"Electrical"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","divert_power","electrical"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -284 76 -249 {CustomName:'{"text":"Electrical"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","upload_data","electrical"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}

# Admin
summon minecraft:armor_stand -254 76 -253 {CustomName:'{"text":"Admin"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","admin"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -249 76 -253 {CustomName:'{"text":"Admin"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","upload_data","admin"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -241 76 -249 {CustomName:'{"text":"Admin"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","swipe_card","admin"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}

# Communications
summon minecraft:armor_stand -247 76 -232 {CustomName:'{"text":"Communications"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","upload_data","communications"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -242 76 -232 {CustomName:'{"text":"Communications"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","communications"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}

# Shields
summon minecraft:armor_stand -235 76 -232 {CustomName:'{"text":"Shields"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","prime_shields","shields"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}
summon minecraft:armor_stand -227 76 -243 {CustomName:'{"text":"Shields"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","shields"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}

# Weapons
summon minecraft:armor_stand -225 76 -274 {CustomName:'{"text":"Weapons"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","weapons"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}
summon minecraft:armor_stand -231 76 -274 {CustomName:'{"text":"Weapons"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","clear_asteroids","weapons"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}
summon minecraft:armor_stand -230 76 -279 {CustomName:'{"text":"Weapons"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","upload_data","weapons"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}

# O2
summon minecraft:armor_stand -235 76 -263 {CustomName:'{"text":"O2"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","o2"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -243 76 -257 {CustomName:'{"text":"O2"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","empty_chute","o2"],DisabledSlots:4144959,CustomNameVisible:0b}
summon minecraft:armor_stand -244 76 -259 {CustomName:'{"text":"O2"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","clean","o2"],DisabledSlots:4144959,Rotation:[90f],CustomNameVisible:0b}

# Navigation
summon minecraft:armor_stand -218 76 -259 {CustomName:'{"text":"Navigation"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","fix_wiring","navigation"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -214 76 -263 {CustomName:'{"text":"Navigation"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","part2","divert_power","navigation"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -212 76 -263 {CustomName:'{"text":"Navigation"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","long","selectable","upload_data","navigation"],DisabledSlots:4144959,Rotation:[180f],CustomNameVisible:0b}
summon minecraft:armor_stand -207 76 -261 {CustomName:'{"text":"Navigation"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","chart","navigation"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}
summon minecraft:armor_stand -207 76 -254 {CustomName:'{"text":"Navigation"}',NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["task","short","selectable","stabilise","navigation"],DisabledSlots:4144959,Rotation:[-90f],CustomNameVisible:0b}


## Cameras
summon minecraft:armor_stand -223 77 -259 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera","c1"],DisabledSlots:4144959,Rotation:[72.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -254 77 -253 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera","c2"],DisabledSlots:4144959,Rotation:[61.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -276 77 -275 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera","c3"],DisabledSlots:4144959,Rotation:[60.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -304 77 -257 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera","c4"],DisabledSlots:4144959,Rotation:[-113.00f,18.00f],Pose:{Head:[15f,0f,0f]}}

summon minecraft:armor_stand -222 77 -259 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera_model","camera1_model"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:player_head",Count:1b,tag:{SkullOwner:"CCTV"}}],Rotation:[72.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -253 77 -253 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera_model","camera2_model"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:player_head",Count:1b,tag:{SkullOwner:"CCTV"}}],Rotation:[61.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -275 77 -275 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera_model","camera3_model"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:player_head",Count:1b,tag:{SkullOwner:"CCTV"}}],Rotation:[60.00f,18.00f],Pose:{Head:[15f,0f,0f]}}
summon minecraft:armor_stand -305 77 -257 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera_model","camera4_model"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:player_head",Count:1b,tag:{SkullOwner:"CCTV"}}],Rotation:[-113.00f,18.00f],Pose:{Head:[15f,0f,0f]}}


summon minecraft:armor_stand -291.0 76.0 -261.0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["camera_marker"],DisabledSlots:4144959,Rotation:[180f]}

## SKIP
summon minecraft:armor_stand 0 64 0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["SKIP_detect","SKIP"],DisabledSlots:4144959,CustomName:'{"text":"SKIP"}',CustomNameVisible:0b}

## Vent-markers
summon minecraft:armor_stand -299 76 -279 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v1"],DisabledSlots:4144959,Rotation:[45f]}
summon minecraft:armor_stand -317 76 -267 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v2"],DisabledSlots:4144959,Rotation:[-40f]}
summon minecraft:armor_stand -313 76 -248 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v3"],DisabledSlots:4144959,Rotation:[180f]}
summon minecraft:armor_stand -299 76 -234 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v4"],DisabledSlots:4144959,Rotation:[135f]}
summon minecraft:armor_stand -289 76 -252 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v5"],DisabledSlots:4144959,Rotation:[143f]}
summon minecraft:armor_stand -284 76 -259 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v6"],DisabledSlots:4144959,Rotation:[-135f]}
summon minecraft:armor_stand -284 76 -250 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v7"],DisabledSlots:4144959,Rotation:[-50f]}
summon minecraft:armor_stand -246 76 -268 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v8"],DisabledSlots:4144959,Rotation:[105f]}
summon minecraft:armor_stand -250 76 -244 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v9"],DisabledSlots:4144959,Rotation:[-135f]}
summon minecraft:armor_stand -233 76 -254 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v10"],DisabledSlots:4144959,Rotation:[-51f]}
summon minecraft:armor_stand -229 76 -279 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v11"],DisabledSlots:4144959,Rotation:[22f]}
summon minecraft:armor_stand -214 76 -261 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v12"],DisabledSlots:4144959,Rotation:[-38f]}
summon minecraft:armor_stand -214 76 -254 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v13"],DisabledSlots:4144959,Rotation:[-135f]}
summon minecraft:armor_stand -232 76 -232 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["vent","v14"],DisabledSlots:4144959,Rotation:[160f]}

## Faking
scoreboard objectives add faked dummy
scoreboard objectives add being_faked dummy
scoreboard players set @e[tag=task] faked 0
scoreboard players set @e[tag=task] being_faked 0

## O2 sabotage markers
summon minecraft:armor_stand -240 76 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage1"],DisabledSlots:4144959}
summon minecraft:armor_stand -240 77 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage2"],DisabledSlots:4144959}
summon minecraft:armor_stand -240 78 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage3"],DisabledSlots:4144959}
summon minecraft:armor_stand -240 79 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage4"],DisabledSlots:4144959}
summon minecraft:armor_stand -239 79 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage5"],DisabledSlots:4144959}
summon minecraft:armor_stand -238 79 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage6"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 79 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage7"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 78 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage8"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 77 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage9"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 76 -263 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["o2_sabotage","o2_sabotage0"],DisabledSlots:4144959}
execute as @e[tag=o2_sabotage] at @s run setblock ~ ~ ~ air
#execute as @e[tag=o2_sabotage] at @s run setblock ~ ~ ~ lever[face=wall,facing=south,powered=true]

## Lights
fill -284 78 -241 -280 78 -241 lever[powered=true,face=wall,facing=south]
fill -284 77 -242 -280 77 -242 redstone_lamp[lit=true]

## Doors
scoreboard objectives add location dummy
scoreboard players set @a location 0
scoreboard objectives add close_door dummy
summon minecraft:armor_stand -244 76 -273 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -244 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -259 76 -259 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -258 76 -259 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -273 76 -273 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -273 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","cafeteria"],DisabledSlots:4144959}
summon minecraft:armor_stand -298 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","upper_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -298 76 -273 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","upper_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -302 76 -267 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","upper_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -303 76 -267 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","upper_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -308 76 -257 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","reactor"],DisabledSlots:4144959}
summon minecraft:armor_stand -308 76 -258 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","reactor"],DisabledSlots:4144959}
summon minecraft:armor_stand -303 76 -246 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","lower_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -302 76 -246 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","lower_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -298 76 -239 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","lower_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -298 76 -240 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","lower_engine"],DisabledSlots:4144959}
summon minecraft:armor_stand -295 76 -257 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","security"],DisabledSlots:4144959}
summon minecraft:armor_stand -295 76 -258 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","security"],DisabledSlots:4144959}
summon minecraft:armor_stand -283 76 -271 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","med_bay"],DisabledSlots:4144959}
summon minecraft:armor_stand -282 76 -271 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","med_bay"],DisabledSlots:4144959}
summon minecraft:armor_stand -282 76 -234 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","electrical"],DisabledSlots:4144959}
summon minecraft:armor_stand -283 76 -234 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","electrical"],DisabledSlots:4144959}
summon minecraft:armor_stand -259 76 -248 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -258 76 -248 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -256 76 -238 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -256 76 -237 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -271 76 -231 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -271 76 -232 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","storage"],DisabledSlots:4144959}
summon minecraft:armor_stand -244 76 -233 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","communications"],DisabledSlots:4144959}
summon minecraft:armor_stand -245 76 -233 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","communications"],DisabledSlots:4144959}
summon minecraft:armor_stand -252 76 -251 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","admin"],DisabledSlots:4144959}
summon minecraft:armor_stand -252 76 -252 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","admin"],DisabledSlots:4144959}
summon minecraft:armor_stand -233 76 -244 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","shields"],DisabledSlots:4144959}
summon minecraft:armor_stand -232 76 -244 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","shields"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 76 -237 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","shields"],DisabledSlots:4144959}
summon minecraft:armor_stand -237 76 -238 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","shields"],DisabledSlots:4144959}
summon minecraft:armor_stand -230 76 -267 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","weapons"],DisabledSlots:4144959}
summon minecraft:armor_stand -231 76 -267 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","weapons"],DisabledSlots:4144959}
summon minecraft:armor_stand -235 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","weapons"],DisabledSlots:4144959}
summon minecraft:armor_stand -235 76 -273 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","weapons"],DisabledSlots:4144959}
summon minecraft:armor_stand -236 76 -262 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","o2"],DisabledSlots:4144959}
summon minecraft:armor_stand -236 76 -261 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","o2"],DisabledSlots:4144959}
summon minecraft:armor_stand -215 76 -257 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","navigation"],DisabledSlots:4144959}
summon minecraft:armor_stand -215 76 -258 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["door","navigation"],DisabledSlots:4144959}
scoreboard players set @e[tag=door] close_door 0

## Admin map
summon minecraft:armor_stand -245 77 -249.1 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["model","map124"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:29}}]}

## Sabotage alerts
summon minecraft:armor_stand -235.0 77 -260 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["alert","o2_alert"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:32}}],Rotation:[90f]}
summon minecraft:armor_stand -241 77 -253.0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["alert","o2_alert"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:32}}],Rotation:[0f]}
summon minecraft:armor_stand -308 77 -256.0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["alert","reactor_alert"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:32}}],Rotation:[0f]}
summon minecraft:armor_stand -279 77 -241.0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["alert","lights_alert"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:32}}],Rotation:[0f]}
summon minecraft:armor_stand -247 76 -224.0 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["alert","comms_alert"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:32}}],Rotation:[0f]}
team join alert @e[tag=alert]

## Cafeteria spawn
summon minecraft:armor_stand -259 76 -277 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn0"],DisabledSlots:4144959}
summon minecraft:armor_stand -258 76 -277 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn2"],DisabledSlots:4144959}
summon minecraft:armor_stand -257 76 -276 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn4"],DisabledSlots:4144959}
summon minecraft:armor_stand -256 76 -275 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn6"],DisabledSlots:4144959}
summon minecraft:armor_stand -255 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn8"],DisabledSlots:4144959}
summon minecraft:armor_stand -261 76 -272 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn1"],DisabledSlots:4144959}
summon minecraft:armor_stand -262 76 -273 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn3"],DisabledSlots:4144959}
summon minecraft:armor_stand -262 76 -274 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn5"],DisabledSlots:4144959}
summon minecraft:armor_stand -261 76 -275 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn7"],DisabledSlots:4144959}
summon minecraft:armor_stand -260 76 -276 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["cafeteria_spawn","spawn9"],DisabledSlots:4144959}
execute as @e[tag=cafeteria_spawn] at @s facing -258.00 76.00 -273.00 run tp @s ~ ~ ~ ~ ~


## Outside map
#summon minecraft:armor_stand -231 2 1 {NoGravity:1b,Invulnerable:1b,Marker:1b,Invisible:1b,Tags:["start_button"],DisabledSlots:4144959,ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:31}}]}

