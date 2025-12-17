from __future__ import annotations
from dataclasses import dataclass
from typing import Optional
from .habitat import Habitat

@dataclass
class Animal:
    name: str
    energy: int
    age: int = 0
    habitat: Optional[Habitat] = None

    # getters / setters
    def get_name(self) -> str:
        return self.name

    def get_energy(self) -> int:
        return self.energy

    def get_age(self) -> int:
        return self.age

    def get_habitat(self) -> Optional[Habitat]:
        return self.habitat

    def set_habitat(self, habitat: Optional[Habitat]) -> None:
        self.habitat = habitat

    def eat(self, amount: int) -> None:
        # Java: amount < 0 -> IllegalArgumentException("Amount must be positive")
        if amount < 0:
            raise ValueError("Amount must be positive")
        self.energy += amount

    def grow_old(self) -> None:
        # Java: age += 1
        self.age += 1
        # Java: energy -= 5
        self.energy = max(0, self.energy - 5)

    def move_to(self, habitat: Habitat) -> None:
        if self.energy >= 10:
            self.habitat = habitat
            self.energy -= 10

    def leave_habitat(self) -> None:
        self.habitat = None

    def has_habitat(self) -> bool:
        return self.habitat is not None

    def describe(self) -> str:
        if self.has_habitat():
            return f"{self.name} ({self.energy} energy) lives in {self.habitat.get_type()}"
        return f"{self.name} ({self.energy} energy) is homeless"

    def calculate_daily_needs(self) -> int:
        if self.habitat is None:
            return 20
        t = self.habitat.get_type()
        if t == "Desert":
            return 40
        if t == "Forest":
            return 25
        if t == "Savanna":
            return 30
        return 20

    def can_survive(self) -> bool:
        return self.energy >= self.calculate_daily_needs()
