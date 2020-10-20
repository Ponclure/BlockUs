## Cafeteria
execute if entity @e[tag=cafeteria,tag=fix_wiring,tag=incomplete] if block -300 202 -307 redstone_lamp[lit=true] if block -298 202 -307 redstone_lamp[lit=true] if block -296 202 -307 redstone_lamp[lit=true] if block -294 202 -307 redstone_lamp[lit=true] run function scripts:task_success/cafeteria/fix_wiring
execute if entity @e[tag=cafeteria,tag=upload_data,tag=incomplete] if block -284 202 -307 minecraft:command_block{powered:1b} run function scripts:task_success/cafeteria/upload_data
execute if entity @e[tag=cafeteria,tag=empty_garbage,tag=incomplete] if blocks -275 201 -305 -279 202 -306 -279 206 -305 all run function scripts:task_success/cafeteria/empty_garbage

## Upper Engine
execute if entity @e[tag=upper_engine,tag=divert_power,tag=incomplete] if block -263 202 -304 redstone_lamp[lit=true] run function scripts:task_success/upper_engine/divert_power
execute if entity @e[tag=upper_engine,tag=align_engine,tag=incomplete] if block -260 202 -305 redstone_lamp[lit=true] run function scripts:task_success/upper_engine/align_engine
execute if entity @e[tag=upper_engine,tag=fuel,tag=incomplete] if blocks -248 201 -306 -246 201 -304 -248 206 -306 all run function scripts:task_success/upper_engine/fuel

### Reactor
execute if entity @e[tag=reactor,tag=divert_power,tag=incomplete] if block -233 202 -304 redstone_lamp[lit=true] run function scripts:task_success/reactor/divert_power
execute if entity @e[tag=reactor,tag=unlock_manifolds,tag=incomplete] if block -299 202 -315 redstone_lamp[lit=true] if block -299 202 -317 redstone_lamp[lit=true] if block -297 202 -316 redstone_lamp[lit=true] if block -295 202 -317 redstone_lamp[lit=true] if block -295 202 -315 redstone_lamp[lit=true] run function scripts:task_success/reactor/unlock_manifolds
execute if entity @e[tag=reactor,tag=start_reactor,tag=incomplete] if blocks -287 202 -315 -287 202 -315 -287 206 -315 all run function scripts:task_success/reactor/start_reactor

### Lower Engine
execute if entity @e[tag=lower_engine,tag=divert_power,tag=incomplete] if block -273 202 -315 redstone_lamp[lit=true] run function scripts:task_success/lower_engine/divert_power
execute if entity @e[tag=lower_engine,tag=align_engine,tag=incomplete] if block -270 202 -316 redstone_lamp[lit=true] run function scripts:task_success/lower_engine/align_engine
execute if entity @e[tag=lower_engine,tag=fuel,tag=incomplete] if blocks -258 201 -317 -256 201 -315 -248 206 -306 all run function scripts:task_success/lower_engine/fuel

## Security
execute if entity @e[tag=security,tag=fix_wiring,tag=incomplete] if block -250 202 -318 redstone_lamp[lit=true] if block -248 202 -318 redstone_lamp[lit=true] if block -246 202 -318 redstone_lamp[lit=true] if block -244 202 -318 redstone_lamp[lit=true] run function scripts:task_success/security/fix_wiring
execute if entity @e[tag=security,tag=divert_power,tag=incomplete] if block -233 202 -315 redstone_lamp[lit=true] run function scripts:task_success/security/divert_power

## Med Bay
execute if entity @e[tag=med_bay,tag=inspect_sample,tag=incomplete] if score inspect_sample inspect_sample matches 0 run function scripts:task_success/med_bay/inspect_sample
execute if entity @e[tag=med_bay,tag=submit_scan,tag=incomplete] if score submit_scan submit_scan matches 0 run function scripts:task_success/med_bay/submit_scan

## Storage
execute if entity @e[tag=storage,tag=fix_wiring,tag=incomplete] if block -300 202 -329 redstone_lamp[lit=true] if block -298 202 -329 redstone_lamp[lit=true] if block -296 202 -329 redstone_lamp[lit=true] if block -294 202 -329 redstone_lamp[lit=true] run function scripts:task_success/storage/fix_wiring
execute if entity @e[tag=storage,tag=fuel1,tag=incomplete] if block -287 201 -327 #scripts:air run function scripts:task_success/storage/fuel1
execute if entity @e[tag=storage,tag=fuel2,tag=incomplete] if block -277 201 -327 #scripts:air run function scripts:task_success/storage/fuel2
execute if entity @e[tag=storage,tag=empty_garbage,tag=incomplete] if blocks -265 201 -327 -269 202 -328 -279 206 -305 all run function scripts:task_success/storage/empty_garbage
execute if entity @e[tag=storage,tag=empty_chute,tag=incomplete] if blocks -255 201 -327 -259 202 -328 -279 206 -305 all run function scripts:task_success/storage/empty_chute

## Electrical
execute if entity @e[tag=electrical,tag=calibrate,tag=incomplete] if block -244 202 -327 redstone_lamp[lit=true] run function scripts:task_success/electrical/calibrate
execute if entity @e[tag=electrical,tag=fix_wiring,tag=incomplete] if block -240 202 -329 redstone_lamp[lit=true] if block -238 202 -329 redstone_lamp[lit=true] if block -236 202 -329 redstone_lamp[lit=true] if block -234 202 -329 redstone_lamp[lit=true] run function scripts:task_success/electrical/fix_wiring
execute if entity @e[tag=electrical,tag=divert_power,tag=incomplete] if block -297 202 -341 redstone_lamp[lit=true] run function scripts:task_success/electrical/divert_power
execute if entity @e[tag=electrical,tag=upload_data,tag=incomplete] if block -284 202 -340 minecraft:command_block{powered:1b} run function scripts:task_success/electrical/upload_data

## Admin
execute if entity @e[tag=admin,tag=fix_wiring,tag=incomplete] if block -280 202 -340 redstone_lamp[lit=true] if block -278 202 -340 redstone_lamp[lit=true] if block -276 202 -340 redstone_lamp[lit=true] if block -274 202 -340 minecraft:redstone_lamp[lit=true] run function scripts:task_success/admin/fix_wiring
execute if entity @e[tag=admin,tag=upload_data,tag=incomplete] if block -270 202 -340 minecraft:command_block{powered:1b} run function scripts:task_success/admin/upload_data
execute if entity @e[tag=admin,tag=swipe_card,tag=incomplete] if block -258 202 -337 hopper{Items:[{Slot:2b,id:"minecraft:paper",Count:1b}]} if block -255 202 -339 redstone_lamp[lit=true] run function scripts:task_success/admin/swipe_card

## Communications
execute if entity @e[tag=communications,tag=upload_data,tag=incomplete] if block -244 202 -340 minecraft:command_block{powered:1b} run function scripts:task_success/communications/upload_data
execute if entity @e[tag=communications,tag=divert_power,tag=incomplete] if block -233 202 -337 redstone_lamp[lit=true] run function scripts:task_success/communications/divert_power

## Shields
execute if entity @e[tag=shields,tag=prime_shields,tag=incomplete] if block -300 203 -348 minecraft:red_concrete if block -299 204 -348 minecraft:red_concrete if block -299 202 -348 minecraft:red_concrete if block -298 203 -348 minecraft:red_concrete if block -297 204 -348 minecraft:red_concrete if block -297 202 -348 minecraft:red_concrete if block -296 203 -348 minecraft:red_concrete if block -295 204 -348 minecraft:red_concrete if block -295 202 -348 minecraft:red_concrete if block -294 203 -348 minecraft:red_concrete run function scripts:task_success/shields/prime_shields
execute if entity @e[tag=shields,tag=divert_power,tag=incomplete] if block -283 202 -348 redstone_lamp[lit=true] run function scripts:task_success/shields/divert_power

## Weapons
execute if entity @e[tag=weapons,tag=divert_power,tag=incomplete] if block -273 202 -348 redstone_lamp[lit=true] run function scripts:task_success/weapons/divert_power
execute if entity @e[tag=weapons,tag=clear_asteroids,tag=incomplete] if blocks -270 204 -350 -264 202 -347 -241 200 -363 all run function scripts:task_success/weapons/clear_asteroids
execute if entity @e[tag=weapons,tag=upload_data,tag=incomplete] if block -254 202 -351 command_block{powered:1b} run function scripts:task_success/weapons/upload_data

## O2
execute if entity @e[tag=o2,tag=divert_power,tag=incomplete] if block -243 202 -348 redstone_lamp[lit=true] run function scripts:task_success/o2/divert_power
execute if entity @e[tag=o2,tag=empty_chute,tag=incomplete] if blocks -235 201 -349 -239 202 -350 -279 206 -305 all run function scripts:task_success/o2/empty_chute
execute if entity @e[tag=o2,tag=clean,tag=incomplete] if blocks -294 202 -358 -300 204 -361 -241 200 -363 all run function scripts:task_success/o2/clean

## Navigation
execute if entity @e[tag=navigation,tag=fix_wiring,tag=incomplete] if block -290 202 -362 redstone_lamp[lit=true] if block -288 202 -362 redstone_lamp[lit=true] if block -286 202 -362 redstone_lamp[lit=true] if block -284 202 -362 minecraft:redstone_lamp[lit=true] run function scripts:task_success/navigation/fix_wiring
execute if entity @e[tag=navigation,tag=divert_power,tag=incomplete] if block -273 202 -359 redstone_lamp[lit=true] run function scripts:task_success/navigation/divert_power
execute if entity @e[tag=navigation,tag=upload_data,tag=incomplete] if block -264 202 -362 command_block{powered:1b} run function scripts:task_success/navigation/upload_data
execute if entity @e[tag=navigation,tag=chart,tag=incomplete] if block -259 202 -359 redstone_lamp[lit=true] if block -258 203 -359 redstone_lamp[lit=true] if block -257 204 -359 redstone_lamp[lit=true] if block -256 203 -359 redstone_lamp[lit=true] if block -255 204 -359 minecraft:redstone_lamp[lit=true] run function scripts:task_success/navigation/chart
execute if entity @e[tag=navigation,tag=stabilise,tag=incomplete] if block -248 203 -360 minecraft:redstone_lamp[lit=true] if block -247 204 -360 minecraft:redstone_lamp[lit=true] if block -246 203 -360 minecraft:redstone_lamp[lit=true] if block -247 202 -360 redstone_lamp[lit=true] run function scripts:task_success/navigation/stabilise

