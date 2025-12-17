class Habitat:
    def __init__(self, habitat_type: str):
        self.type = habitat_type  

    def get_type(self) -> str:
        return self.type

    def __str__(self) -> str:
        return self.type
